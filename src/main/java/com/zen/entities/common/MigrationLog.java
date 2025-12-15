package com.zen.entities.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "migration_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private MigrationJob job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id")
    private MigrationStage stage;

    // Log information
    @Enumerated(EnumType.STRING)
    @Column(name = "log_level", nullable = false)
    @Builder.Default
    private LogLevel logLevel = LogLevel.INFO;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "details", columnDefinition = "JSON")
    private String details;

    // Context information
    @Column(name = "entity_type", length = 100)
    private String entityType;

    @Column(name = "entity_id", length = 255)
    private String entityId;

    @Column(name = "source_record_id", length = 255)
    private String sourceRecordId;

    @Column(name = "batch_number")
    private Integer batchNumber;

    // Error context (for ERROR/FATAL logs)
    @Column(name = "error_code", length = 100)
    private String errorCode;

    @Column(name = "stack_trace", columnDefinition = "TEXT")
    private String stackTrace;

    // Performance context
    @Column(name = "execution_time_ms")
    private Long executionTimeMs;

    @Column(name = "memory_usage_mb")
    private Integer memoryUsageMb;

    // Timing
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public enum LogLevel {
        DEBUG("Debug", "Detailed information for debugging"),
        INFO("Info", "General information about migration progress"),
        WARN("Warning", "Warning messages about potential issues"),
        ERROR("Error", "Error messages about failures"),
        FATAL("Fatal", "Fatal errors that stop migration");

        private final String displayName;
        private final String description;

        LogLevel(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getDescription() {
            return description;
        }

        public boolean isErrorLevel() {
            return this == ERROR || this == FATAL;
        }

        public boolean isWarningLevel() {
            return this == WARN;
        }

        public String getLogColor() {
            return switch (this) {
                case DEBUG -> "#808080"; // Gray
                case INFO -> "#0066CC"; // Blue
                case WARN -> "#FF8C00"; // Orange
                case ERROR -> "#DC143C"; // Red
                case FATAL -> "#8B0000"; // Dark Red
            };
        }

        public String getLogIcon() {
            return switch (this) {
                case DEBUG -> "🔍";
                case INFO -> "ℹ️";
                case WARN -> "⚠️";
                case ERROR -> "❌";
                case FATAL -> "💀";
            };
        }
    }

    // Helper methods
    public boolean isError() {
        return logLevel != null && logLevel.isErrorLevel();
    }

    public boolean isWarning() {
        return logLevel != null && logLevel.isWarningLevel();
    }

    public String getFormattedMessage() {
        StringBuilder sb = new StringBuilder();
        
        if (logLevel != null) {
            sb.append("[").append(logLevel.getDisplayName().toUpperCase()).append("] ");
        }
        
        if (entityType != null) {
            sb.append("[").append(entityType).append("] ");
        }
        
        if (batchNumber != null) {
            sb.append("[Batch ").append(batchNumber).append("] ");
        }
        
        sb.append(message);
        
        return sb.toString();
    }

    public String getContextInfo() {
        StringBuilder sb = new StringBuilder();
        
        if (entityType != null) {
            sb.append("Entity: ").append(entityType);
        }
        
        if (entityId != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("ID: ").append(entityId);
        }
        
        if (sourceRecordId != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Source ID: ").append(sourceRecordId);
        }
        
        if (batchNumber != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Batch: ").append(batchNumber);
        }
        
        if (executionTimeMs != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Time: ").append(executionTimeMs).append("ms");
        }
        
        return sb.toString();
    }

    // Static factory methods
    public static MigrationLog debug(MigrationJob job, String message) {
        return MigrationLog.builder()
                .job(job)
                .logLevel(LogLevel.DEBUG)
                .message(message)
                .build();
    }

    public static MigrationLog info(MigrationJob job, String message) {
        return MigrationLog.builder()
                .job(job)
                .logLevel(LogLevel.INFO)
                .message(message)
                .build();
    }

    public static MigrationLog warn(MigrationJob job, String message) {
        return MigrationLog.builder()
                .job(job)
                .logLevel(LogLevel.WARN)
                .message(message)
                .build();
    }

    public static MigrationLog error(MigrationJob job, String message) {
        return MigrationLog.builder()
                .job(job)
                .logLevel(LogLevel.ERROR)
                .message(message)
                .build();
    }

    public static MigrationLog fatal(MigrationJob job, String message) {
        return MigrationLog.builder()
                .job(job)
                .logLevel(LogLevel.FATAL)
                .message(message)
                .build();
    }

    public static MigrationLog stageInfo(MigrationStage stage, String message) {
        return MigrationLog.builder()
                .job(stage.getJob())
                .stage(stage)
                .logLevel(LogLevel.INFO)
                .message(message)
                .entityType(stage.getEntityType())
                .build();
    }

    public static MigrationLog stageError(MigrationStage stage, String message, Exception e) {
        return MigrationLog.builder()
                .job(stage.getJob())
                .stage(stage)
                .logLevel(LogLevel.ERROR)
                .message(message)
                .entityType(stage.getEntityType())
                .stackTrace(e != null ? getStackTrace(e) : null)
                .build();
    }

    private static String getStackTrace(Exception e) {
        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}