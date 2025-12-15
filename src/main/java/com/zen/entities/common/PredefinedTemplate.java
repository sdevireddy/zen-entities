package com.zen.entities.common;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "predefined_templates")
public class PredefinedTemplate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "template_type", nullable = false)
    private TemplateType templateType;
    
    @Column(name = "category", nullable = false, length = 100)
    private String category;
    
    @Column(name = "thumbnail_url", length = 500)
    private String thumbnailUrl;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "blocks", columnDefinition = "JSON", nullable = false)
    private String blocks;
    
    @Column(name = "styles", columnDefinition = "JSON")
    private String styles;
    
    @Column(name = "variables", columnDefinition = "JSON")
    private String variables;
    
    @Column(name = "design_type", length = 20)
    private String designType = "visual";
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public PredefinedTemplate() {}
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public TemplateType getTemplateType() {
        return templateType;
    }
    
    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getBlocks() {
        return blocks;
    }
    
    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }
    
    public String getStyles() {
        return styles;
    }
    
    public void setStyles(String styles) {
        this.styles = styles;
    }
    
    public String getVariables() {
        return variables;
    }
    
    public void setVariables(String variables) {
        this.variables = variables;
    }
    
    public String getDesignType() {
        return designType;
    }
    
    public void setDesignType(String designType) {
        this.designType = designType;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // Enum for template types
    public enum TemplateType {
        QUOTE,
        INVOICE,
        SALES_ORDER,
        PURCHASE_ORDER
    }
}
