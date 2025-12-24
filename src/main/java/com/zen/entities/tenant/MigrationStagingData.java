package com.zen.entities.tenant;

import com.zen.entities.common.MigrationJob;
import com.zen.entities.common.MigrationStage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "migration_staging_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationStagingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_id", nullable = false)
    private Long jobId;

    @Column(name = "stage_id", nullable = false)
    private Long stageId;

    // Record information
    @Column(name = "entity_type", nullable = false, length = 100)
    private String entityType;

    @Column(name = "source_record_id", nullable = false, length = 255)
    private String sourceRecordId;

    @Column(name = "source_data", nullable = false, columnDefinition = "JSON")
    private String sourceData;

    @Column(name = "transformed_data", columnDefinition = "JSON")
    private String transformedData;

    // Processing status
    @Enumerated(EnumType.STRING)
    @Column(name = "processing_status")
    @Builder.Default
    private ProcessingStatus processingStatus = ProcessingStatus.EXTRACTED;

    @Column(name = "processing_step", length = 100)
    private String processingStep;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    // Relationships and dependencies
    @Column(name = "parent_record_id", length = 255)
    private String parentRecordId;

    @Column(name = "dependencies", columnDefinition = "JSON")
    private String dependencies;

    @Column(name = "external_references", columnDefinition = "JSON")
    private String externalReferences;

    // Data quality metrics
    @Column(name = "data_quality_score", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal dataQualityScore;

    @Column(name = "completeness_score", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal completenessScore;

    @Column(name = "accuracy_score", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal accuracyScore;

    // Processing metadata
    @Column(name = "batch_number")
    private Integer batchNumber;

    @Column(name = "retry_count")
    @Builder.Default
    private Integer retryCount = 0;

    @Column(name = "last_retry_at")
    private LocalDateTime lastRetryAt;

    // Timing
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum ProcessingStatus {
        EXTRACTED("Extracted", "Data has been extracted from source"),
        TRANSFORMED("Transformed", "Data has been transformed"),
        VALIDATED("Validated", "Data has been validated"),
        LOADED("Loaded", "Data has been loaded to target"),
        FAILED("Failed", "Processing failed");

        private final String displayName;
        private final String description;

        ProcessingStatus(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return this == LOADED;
        }

        public boolean isFailed() {
            return this == FAILED;
        }

        public boolean canRetry() {
            return this == FAILED;
        }

        public String getStatusColor() {
            return switch (this) {
                case EXTRACTED -> "#17a2b8"; // Info blue
                case TRANSFORMED -> "#6f42c1"; // Purple
                case VALIDATED -> "#20c997"; // Teal
                case LOADED -> "#28a745"; // Success green
                case FAILED -> "#dc3545"; // Danger red
            };
        }

        public String getStatusIcon() {
            return switch (this) {
                case EXTRACTED -> "📥";
                case TRANSFORMED -> "🔄";
                case VALIDATED -> "✅";
                case LOADED -> "📤";
                case FAILED -> "❌";
            };
        }
    }

    // Helper methods
    public boolean isCompleted() {
        return processingStatus == ProcessingStatus.LOADED;
    }

    public boolean isFailed() {
        return processingStatus == ProcessingStatus.FAILED;
    }

    public boolean canRetry() {
        return processingStatus == ProcessingStatus.FAILED;
    }

    public void markAsExtracted() {
        this.processingStatus = ProcessingStatus.EXTRACTED;
        this.processingStep = "Data extracted from source";
    }

    public void markAsTransformed(String transformedData) {
        this.processingStatus = ProcessingStatus.TRANSFORMED;
        this.transformedData = transformedData;
        this.processingStep = "Data transformed";
    }

    public void markAsValidated() {
        this.processingStatus = ProcessingStatus.VALIDATED;
        this.processingStep = "Data validated";
    }

    public void markAsLoaded() {
        this.processingStatus = ProcessingStatus.LOADED;
        this.processingStep = "Data loaded to target";
    }

    public void markAsFailed(String errorMessage) {
        this.processingStatus = ProcessingStatus.FAILED;
        this.errorMessage = errorMessage;
        this.processingStep = "Processing failed";
    }

    public void incrementRetryCount() {
        this.retryCount = (this.retryCount == null ? 0 : this.retryCount) + 1;
        this.lastRetryAt = LocalDateTime.now();
    }

    public void setDataQualityScores(double dataQuality, double completeness, double accuracy) {
        this.dataQualityScore = BigDecimal.valueOf(dataQuality);
        this.completenessScore = BigDecimal.valueOf(completeness);
        this.accuracyScore = BigDecimal.valueOf(accuracy);
    }

    public double getOverallQualityScore() {
        if (dataQualityScore == null && completenessScore == null && accuracyScore == null) {
            return 0.0;
        }
        
        double total = 0.0;
        int count = 0;
        
        if (dataQualityScore != null) {
            total += dataQualityScore.doubleValue();
            count++;
        }
        
        if (completenessScore != null) {
            total += completenessScore.doubleValue();
            count++;
        }
        
        if (accuracyScore != null) {
            total += accuracyScore.doubleValue();
            count++;
        }
        
        return count > 0 ? total / count : 0.0;
    }

    public String getFormattedQualityScore() {
        double score = getOverallQualityScore();
        return String.format("%.1f%%", score);
    }

    public String getQualityGrade() {
        double score = getOverallQualityScore();
        
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public String getProcessingInfo() {
        StringBuilder sb = new StringBuilder();
        
        if (processingStatus != null) {
            sb.append("Status: ").append(processingStatus.getDisplayName());
        }
        
        if (processingStep != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Step: ").append(processingStep);
        }
        
        if (batchNumber != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Batch: ").append(batchNumber);
        }
        
        if (retryCount != null && retryCount > 0) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Retries: ").append(retryCount);
        }
        
        return sb.toString();
    }

    // Static factory methods
    public static MigrationStagingData createExtracted(Long jobId, Long stageId, 
                                                      String entityType, String sourceRecordId, 
                                                      String sourceData, Integer batchNumber) {
        return MigrationStagingData.builder()
                .jobId(jobId)
                .stageId(stageId)
                .entityType(entityType)
                .sourceRecordId(sourceRecordId)
                .sourceData(sourceData)
                .processingStatus(ProcessingStatus.EXTRACTED)
                .processingStep("Data extracted from source")
                .batchNumber(batchNumber)
                .build();
    }
}