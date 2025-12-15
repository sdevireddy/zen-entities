package com.zen.entities.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "migration_field_mappings", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"source_crm_type", "entity_type", "source_field"}))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigrationFieldMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapping configuration
    @Column(name = "source_crm_type", nullable = false, length = 50)
    private String sourceCrmType;

    @Column(name = "entity_type", nullable = false, length = 100)
    private String entityType;

    @Column(name = "source_field", nullable = false, length = 255)
    private String sourceField;

    @Column(name = "target_field", nullable = false, length = 255)
    private String targetField;

    // Transformation rules
    @Enumerated(EnumType.STRING)
    @Column(name = "transformation_type")
    @Builder.Default
    private TransformationType transformationType = TransformationType.DIRECT;

    @Column(name = "transformation_config", columnDefinition = "JSON")
    private String transformationConfig;

    // Validation rules
    @Column(name = "validation_rules", columnDefinition = "JSON")
    private String validationRules;

    @Column(name = "is_required")
    @Builder.Default
    private Boolean isRequired = false;

    @Column(name = "default_value", columnDefinition = "TEXT")
    private String defaultValue;

    // Field metadata
    @Column(name = "source_field_type", length = 50)
    private String sourceFieldType;

    @Column(name = "target_field_type", length = 50)
    private String targetFieldType;

    @Column(name = "field_description", columnDefinition = "TEXT")
    private String fieldDescription;

    // Status
    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "is_system_mapping")
    @Builder.Default
    private Boolean isSystemMapping = false;

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
    public boolean requiresTransformation() {
        return transformationType != TransformationType.DIRECT;
    }

    public boolean hasValidationRules() {
        return validationRules != null && !validationRules.trim().isEmpty();
    }

    public boolean hasDefaultValue() {
        return defaultValue != null && !defaultValue.trim().isEmpty();
    }

    public String getDisplayName() {
        return String.format("%s.%s -> %s", entityType, sourceField, targetField);
    }

    public String getMappingKey() {
        return String.format("%s_%s_%s", sourceCrmType, entityType, sourceField);
    }

    public boolean isCompatibleFieldTypes() {
        if (sourceFieldType == null || targetFieldType == null) {
            return true; // Assume compatible if types not specified
        }
        
        // Basic type compatibility check
        return switch (sourceFieldType.toLowerCase()) {
            case "string", "text", "varchar" -> 
                targetFieldType.toLowerCase().matches("string|text|varchar|char");
            case "integer", "int", "number" -> 
                targetFieldType.toLowerCase().matches("integer|int|number|bigint|long");
            case "decimal", "double", "float" -> 
                targetFieldType.toLowerCase().matches("decimal|double|float|number");
            case "boolean", "bool" -> 
                targetFieldType.toLowerCase().matches("boolean|bool|tinyint");
            case "date", "datetime", "timestamp" -> 
                targetFieldType.toLowerCase().matches("date|datetime|timestamp");
            default -> true; // Allow unknown types
        };
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void markAsSystemMapping() {
        this.isSystemMapping = true;
    }

    public void markAsUserMapping() {
        this.isSystemMapping = false;
    }
}