package com.zen.entities.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "migration_jobs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_key", unique = true, nullable = false, length = 100)
    private String jobKey;

    @Column(name = "tenant_id", nullable = false, length = 100)
    private String tenantId;

    @Enumerated(EnumType.STRING)
    @Column(name = "source_crm_type", nullable = false)
    private CrmType sourceCrmType;

    @Column(name = "source_config", columnDefinition = "JSON")
    private String sourceConfig;

    @Column(name = "migration_config", columnDefinition = "JSON")
    private String migrationConfig;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private MigrationStatus status = MigrationStatus.PENDING;

    @Column(name = "progress_percentage")
    @Builder.Default
    private Integer progressPercentage = 0;

    @Column(name = "current_stage", length = 100)
    private String currentStage;

    // Timing fields
    @Column(name = "scheduled_at")
    private LocalDateTime scheduledAt;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "estimated_completion")
    private LocalDateTime estimatedCompletion;

    // Results fields
    @Column(name = "total_records_expected")
    @Builder.Default
    private Integer totalRecordsExpected = 0;

    @Column(name = "total_records_processed")
    @Builder.Default
    private Integer totalRecordsProcessed = 0;

    @Column(name = "total_records_success")
    @Builder.Default
    private Integer totalRecordsSuccess = 0;

    @Column(name = "total_records_failed")
    @Builder.Default
    private Integer totalRecordsFailed = 0;

    // Error handling
    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @Column(name = "error_details", columnDefinition = "JSON")
    private String errorDetails;

    @Column(name = "retry_count")
    @Builder.Default
    private Integer retryCount = 0;

    @Column(name = "max_retries")
    @Builder.Default
    private Integer maxRetries = 3;

    // Performance metrics
    @Column(name = "avg_records_per_second", precision = 10, scale = 2)
    @Builder.Default
    private Double avgRecordsPerSecond = 0.0;

    @Column(name = "peak_memory_usage_mb")
    @Builder.Default
    private Integer peakMemoryUsageMb = 0;

    @Column(name = "total_processing_time_ms")
    @Builder.Default
    private Long totalProcessingTimeMs = 0L;

    // Relationships
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MigrationStage> stages = new ArrayList<>();

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MigrationLog> logs = new ArrayList<>();

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MigrationValidationResult> validationResults = new ArrayList<>();

    // Audit fields
    @Column(name = "created_by")
    private Long createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Helper methods
    public void updateProgress(int progressPercentage) {
        this.progressPercentage = Math.max(0, Math.min(100, progressPercentage));
    }

    public void incrementRetryCount() {
        this.retryCount = (this.retryCount == null ? 0 : this.retryCount) + 1;
    }

    public boolean canRetry() {
        return this.retryCount < this.maxRetries && 
               (this.status == MigrationStatus.FAILED || this.status == MigrationStatus.TIMEOUT);
    }

    public boolean isTerminal() {
        return this.status != null && this.status.isTerminalStatus();
    }

    public boolean isActive() {
        return this.status != null && this.status.isActiveStatus();
    }

    public double getSuccessRate() {
        if (totalRecordsProcessed == null || totalRecordsProcessed == 0) {
            return 0.0;
        }
        return (totalRecordsSuccess.doubleValue() / totalRecordsProcessed.doubleValue()) * 100.0;
    }

    public double getErrorRate() {
        if (totalRecordsProcessed == null || totalRecordsProcessed == 0) {
            return 0.0;
        }
        return (totalRecordsFailed.doubleValue() / totalRecordsProcessed.doubleValue()) * 100.0;
    }

    public Long getDurationMs() {
        if (startedAt == null) {
            return 0L;
        }
        LocalDateTime endTime = completedAt != null ? completedAt : LocalDateTime.now();
        return java.time.Duration.between(startedAt, endTime).toMillis();
    }

    public String getFormattedDuration() {
        Long durationMs = getDurationMs();
        if (durationMs == 0) {
            return "Not started";
        }
        
        long seconds = durationMs / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        
        if (hours > 0) {
            return String.format("%dh %dm %ds", hours, minutes % 60, seconds % 60);
        } else if (minutes > 0) {
            return String.format("%dm %ds", minutes, seconds % 60);
        } else {
            return String.format("%ds", seconds);
        }
    }

    public void addStage(MigrationStage stage) {
        if (this.stages == null) {
            this.stages = new ArrayList<>();
        }
        stage.setJob(this);
        this.stages.add(stage);
    }

    public void addLog(MigrationLog log) {
        if (this.logs == null) {
            this.logs = new ArrayList<>();
        }
        log.setJob(this);
        this.logs.add(log);
    }

    public void addValidationResult(MigrationValidationResult validationResult) {
        if (this.validationResults == null) {
            this.validationResults = new ArrayList<>();
        }
        validationResult.setJob(this);
        this.validationResults.add(validationResult);
    }
}