package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "templates")
public class Template {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TemplateType type;
    
    @Column(name = "category", nullable = false, length = 100)
    private String category;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "thumbnail_url", length = 500)
    private String thumbnailUrl;
    
    @Column(name = "is_predefined")
    private Boolean isPredefined = false;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "created_by")
    private Long createdBy;
    
    @Column(name = "template_data", columnDefinition = "JSON", nullable = false)
    private String templateData;
    
    @Column(name = "styles", columnDefinition = "JSON")
    private String styles;
    
    @Column(name = "variables", columnDefinition = "JSON")
    private String variables;
    
    @Column(name = "design_blocks", columnDefinition = "JSON")
    private String designBlocks;
    
    @Column(name = "design_type", length = 20)
    private String designType = "visual";
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public Template() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public TemplateType getType() { return type; }
    public void setType(TemplateType type) { this.type = type; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
    
    public Boolean getIsPredefined() { return isPredefined; }
    public void setIsPredefined(Boolean isPredefined) { this.isPredefined = isPredefined; }
    
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    
    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    
    public String getTemplateData() { return templateData; }
    public void setTemplateData(String templateData) { this.templateData = templateData; }
    
    public String getStyles() { return styles; }
    public void setStyles(String styles) { this.styles = styles; }
    
    public String getVariables() { return variables; }
    public void setVariables(String variables) { this.variables = variables; }
    
    public String getDesignBlocks() { return designBlocks; }
    public void setDesignBlocks(String designBlocks) { this.designBlocks = designBlocks; }
    
    public String getDesignType() { return designType; }
    public void setDesignType(String designType) { this.designType = designType; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public enum TemplateType {
        quote, invoice, purchase_order, sales_order, email, sms, social_media
    }
}