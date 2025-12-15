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
@Table(name = "migration_stages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private MigrationJob job;

    @Column(name = "stage_name", nullable = false, length = 100)
    private String stageName;

    @Column(name = "stage_order", nullable = false)
    private Integer stageOrder;

    @Column(name = "entity_type", nullable = false, length = 100)
    private String entityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private MigrationStatus status = MigrationStatus.PENDING;

    @Column(name = "progress_percentage")
    @Builder.Default
    private Integer progressPercentage = 0;

    // Processing details
    @Column(name = "records_expected")
    @Builder.Default
    private Integer recordsExpected = 0;

    @Column(name = "records_processed")
    @Builder.Default
    private Integer recordsProcessed = 0;

    @Column(name = "records_success")
    @Builder.Default
    private Integer recordsSuccess = 0;

    @Column(name = "records_failed")
    @Builder.Default
    private Integer recordsFailed = 0;

    @Column(name = "records_skipped")
    @Builder.Default
    private Integer recordsSkipped = 0;

    // Timing
    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "duration_seconds")
    @Builder.Default
    private Integer durationSeconds = 0;

    // Performance metrics
    @Column(name = "extraction_time_ms")
    @Builder.Default
    private Long extractionTimeMs = 0L;

    @Column(name = "transformation_time_ms")
    @Builder.Default
    private Long transformationTimeMs = 0L;

    @Column(name = "validation_time_ms")
    @Builder.Default
    private Long validationTimeMs = 0L;

    @Column(name = "loading_time_ms")
    @Builder.Default
    private Long loadingTimeMs = 0L;

    // Error information
    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @Column(name = "error_details", columnDefinition = "JSON")
    private String errorDetails;

    // Dependencies
    @Column(name = "depends_on_stages", columnDefinition = "JSON")
    private String dependsOnStages;

    // Relationships
    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MigrationLog> logs = new ArrayList<>();

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MigrationValidationResult> validationResults = new ArrayList<>();

    // Audit fields
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

    public void start() {
        this.status = MigrationStatus.RUNNING;
        this.startedAt = LocalDateTime.now();
        this.progressPercentage = 0;
    }

    public void complete() {
        this.status = MigrationStatus.COMPLETED;
        this.completedAt = LocalDateTime.now();
        this.progressPercentage = 100;
        calculateDuration();
    }

    public void fail(String errorMessage) {
        this.status = MigrationStatus.FAILED;
        this.completedAt = LocalDateTime.now();
        this.errorMessage = errorMessage;
        calculateDuration();
    }

    public void pause() {
        this.status = MigrationStatus.PAUSED;
    }

    public void resume() {
        this.status = MigrationStatus.RUNNING;
    }

    private void calculateDuration() {
        if (startedAt != null && completedAt != null) {
            this.durationSeconds = (int) java.time.Duration.between(startedAt, completedAt).getSeconds();
        }
    }

    public double getSuccessRate() {
        if (recordsProcessed == null || recordsProcessed == 0) {
            return 0.0;
        }
        return (recordsSuccess.doubleValue() / recordsProcessed.doubleValue()) * 100.0;
    }

    public double getErrorRate() {
        if (recordsProcessed == null || recordsProcessed == 0) {
            return 0.0;
        }
        return (recordsFailed.doubleValue() / recordsProcessed.doubleValue()) * 100.0;
    }

    public Long getTotalProcessingTimeMs() {
        return extractionTimeMs + transformationTimeMs + validationTimeMs + loadingTimeMs;
    }

    public double getRecordsPerSecond() {
        if (durationSeconds == null || durationSeconds == 0 || recordsProcessed == null) {
            return 0.0;
        }
        return recordsProcessed.doubleValue() / durationSeconds.doubleValue();
    }

    public String getFormattedDuration() {
        if (durationSeconds == null || durationSeconds == 0) {
            return "0s";
        }
        
        int minutes = durationSeconds / 60;
        int seconds = durationSeconds % 60;
        
        if (minutes > 0) {
            return String.format("%dm %ds", minutes, seconds);
        } else {
            return String.format("%ds", seconds);
        }
    }

    public boolean isTerminal() {
        return this.status != null && this.status.isTerminalStatus();
    }

    public boolean isActive() {
        return this.status != null && this.status.isActiveStatus();
    }

    public boolean canStart() {
        return this.status == MigrationStatus.PENDING;
    }

    public boolean canPause() {
        return this.status == MigrationStatus.RUNNING;
    }

    public boolean canResume() {
        return this.status == MigrationStatus.PAUSED;
    }

    public void addLog(MigrationLog log) {
        if (this.logs == null) {
            this.logs = new ArrayList<>();
        }
        log.setStage(this);
        this.logs.add(log);
    }

    public void addValidationResult(MigrationValidationResult validationResult) {
        if (this.validationResults == null) {
            this.validationResults = new ArrayList<>();
        }
        validationResult.setStage(this);
        this.validationResults.add(validationResult);
    }
}