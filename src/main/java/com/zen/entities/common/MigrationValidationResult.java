package com.zen.entities.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "migration_validation_results")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationValidationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private MigrationJob job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id")
    private MigrationStage stage;

    // Validation information
    @Column(name = "entity_type", nullable = false, length = 100)
    private String entityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "validation_type", nullable = false)
    private ValidationType validationType;

    @Column(name = "validation_rule", nullable = false, length = 255)
    private String validationRule;

    // Validation result
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ValidationStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity")
    @Builder.Default
    private ValidationSeverity severity = ValidationSeverity.MEDIUM;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @Column(name = "suggested_fix", columnDefinition = "TEXT")
    private String suggestedFix;

    // Record context
    @Column(name = "source_record_id", length = 255)
    private String sourceRecordId;

    @Column(name = "source_record_data", columnDefinition = "JSON")
    private String sourceRecordData;

    @Column(name = "field_name", length = 255)
    private String fieldName;

    @Column(name = "field_value", columnDefinition = "TEXT")
    private String fieldValue;

    @Column(name = "expected_value", columnDefinition = "TEXT")
    private String expectedValue;

    // Resolution
    @Enumerated(EnumType.STRING)
    @Column(name = "resolution_status")
    @Builder.Default
    private ResolutionStatus resolutionStatus = ResolutionStatus.PENDING;

    @Column(name = "resolution_action", length = 255)
    private String resolutionAction;

    @Column(name = "resolution_details", columnDefinition = "JSON")
    private String resolutionDetails;

    @Column(name = "resolved_by")
    private Long resolvedBy;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    // Timing
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public enum ValidationType {
        FIELD_VALIDATION("Field Validation", "Validation of individual field values"),
        BUSINESS_RULE("Business Rule", "Business logic validation"),
        DEPENDENCY_CHECK("Dependency Check", "Check for required dependencies"),
        DUPLICATE_CHECK("Duplicate Check", "Check for duplicate records"),
        DATA_QUALITY("Data Quality", "Overall data quality assessment");

        private final String displayName;
        private final String description;

        ValidationType(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum ValidationStatus {
        PASS("Pass", "Validation passed successfully"),
        FAIL("Fail", "Validation failed"),
        WARNING("Warning", "Validation passed with warnings");

        private final String displayName;
        private final String description;

        ValidationStatus(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getDescription() {
            return description;
        }

        public boolean isFailure() {
            return this == FAIL;
        }

        public boolean isWarning() {
            return this == WARNING;
        }

        public boolean isSuccess() {
            return this == PASS;
        }

        public String getStatusColor() {
            return switch (this) {
                case PASS -> "#28a745"; // Green
                case WARNING -> "#ffc107"; // Yellow
                case FAIL -> "#dc3545"; // Red
            };
        }

        public String getStatusIcon() {
            return switch (this) {
                case PASS -> "✅";
                case WARNING -> "⚠️";
                case FAIL -> "❌";
            };
        }
    }

    public enum ValidationSeverity {
        LOW("Low", "Minor issue that doesn't affect migration"),
        MEDIUM("Medium", "Issue that may affect data quality"),
        HIGH("High", "Serious issue that affects migration"),
        CRITICAL("Critical", "Critical issue that blocks migration");

        private final String displayName;
        private final String description;

        ValidationSeverity(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCritical() {
            return this == CRITICAL;
        }

        public boolean isHigh() {
            return this == HIGH;
        }

        public String getSeverityColor() {
            return switch (this) {
                case LOW -> "#17a2b8"; // Info blue
                case MEDIUM -> "#ffc107"; // Warning yellow
                case HIGH -> "#fd7e14"; // Warning orange
                case CRITICAL -> "#dc3545"; // Danger red
            };
        }
    }

    public enum ResolutionStatus {
        PENDING("Pending", "Issue is pending resolution"),
        RESOLVED("Resolved", "Issue has been resolved"),
        IGNORED("Ignored", "Issue has been ignored"),
        AUTO_FIXED("Auto Fixed", "Issue was automatically fixed");

        private final String displayName;
        private final String description;

        ResolutionStatus(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getDescription() {
            return description;
        }

        public boolean isResolved() {
            return this == RESOLVED || this == AUTO_FIXED;
        }

        public boolean isPending() {
            return this == PENDING;
        }
    }

    // Helper methods
    public boolean isError() {
        return status == ValidationStatus.FAIL;
    }

    public boolean isWarning() {
        return status == ValidationStatus.WARNING;
    }

    public boolean isSuccess() {
        return status == ValidationStatus.PASS;
    }

    public boolean isCritical() {
        return severity == ValidationSeverity.CRITICAL;
    }

    public boolean isResolved() {
        return resolutionStatus != null && resolutionStatus.isResolved();
    }

    public void resolve(String action, String details, Long resolvedBy) {
        this.resolutionStatus = ResolutionStatus.RESOLVED;
        this.resolutionAction = action;
        this.resolutionDetails = details;
        this.resolvedBy = resolvedBy;
        this.resolvedAt = LocalDateTime.now();
    }

    public void ignore(String reason, Long resolvedBy) {
        this.resolutionStatus = ResolutionStatus.IGNORED;
        this.resolutionAction = "Ignored";
        this.resolutionDetails = reason;
        this.resolvedBy = resolvedBy;
        this.resolvedAt = LocalDateTime.now();
    }

    public void autoFix(String action, String details) {
        this.resolutionStatus = ResolutionStatus.AUTO_FIXED;
        this.resolutionAction = action;
        this.resolutionDetails = details;
        this.resolvedAt = LocalDateTime.now();
    }

    public String getFormattedMessage() {
        StringBuilder sb = new StringBuilder();
        
        if (status != null) {
            sb.append("[").append(status.getDisplayName().toUpperCase()).append("] ");
        }
        
        if (validationType != null) {
            sb.append("[").append(validationType.getDisplayName()).append("] ");
        }
        
        if (fieldName != null) {
            sb.append("Field '").append(fieldName).append("': ");
        }
        
        sb.append(errorMessage != null ? errorMessage : "Validation issue");
        
        return sb.toString();
    }

    public String getContextInfo() {
        StringBuilder sb = new StringBuilder();
        
        if (entityType != null) {
            sb.append("Entity: ").append(entityType);
        }
        
        if (sourceRecordId != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Record ID: ").append(sourceRecordId);
        }
        
        if (fieldName != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Field: ").append(fieldName);
        }
        
        if (fieldValue != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("Value: ").append(fieldValue);
        }
        
        return sb.toString();
    }

    // Static factory methods
    public static MigrationValidationResult fieldValidationError(MigrationJob job, String entityType, 
                                                               String fieldName, String fieldValue, 
                                                               String errorMessage) {
        return MigrationValidationResult.builder()
                .job(job)
                .entityType(entityType)
                .validationType(ValidationType.FIELD_VALIDATION)
                .validationRule("Field validation")
                .status(ValidationStatus.FAIL)
                .severity(ValidationSeverity.MEDIUM)
                .fieldName(fieldName)
                .fieldValue(fieldValue)
                .errorMessage(errorMessage)
                .build();
    }

    public static MigrationValidationResult businessRuleError(MigrationJob job, String entityType, 
                                                            String rule, String errorMessage) {
        return MigrationValidationResult.builder()
                .job(job)
                .entityType(entityType)
                .validationType(ValidationType.BUSINESS_RULE)
                .validationRule(rule)
                .status(ValidationStatus.FAIL)
                .severity(ValidationSeverity.HIGH)
                .errorMessage(errorMessage)
                .build();
    }

    public static MigrationValidationResult dependencyError(MigrationJob job, String entityType, 
                                                          String dependency, String errorMessage) {
        return MigrationValidationResult.builder()
                .job(job)
                .entityType(entityType)
                .validationType(ValidationType.DEPENDENCY_CHECK)
                .validationRule("Dependency check: " + dependency)
                .status(ValidationStatus.FAIL)
                .severity(ValidationSeverity.CRITICAL)
                .errorMessage(errorMessage)
                .build();
    }
}