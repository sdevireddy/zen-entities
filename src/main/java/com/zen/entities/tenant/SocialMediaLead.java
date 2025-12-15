package com.zen.entities.tenant;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "social_media_leads")
public class SocialMediaLead {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tenant_id", nullable = false)
    private String tenantId;
    
    @Column(name = "platform", nullable = false)
    private String platform; // facebook, linkedin, twitter, instagram
    
    @Column(name = "platform_lead_id", nullable = false)
    private String platformLeadId;
    
    @Column(name = "campaign_id")
    private String campaignId;
    
    @Column(name = "campaign_name")
    private String campaignName;
    
    @Column(name = "crm_lead_id")
    private Long crmLeadId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "lead_score")
    private Integer leadScore;
    
    @Column(name = "status")
    private String status; // IMPORTED, PROCESSED, CONVERTED, REJECTED
    
    @Column(name = "assigned_to")
    private Long assignedTo;
    
    @Column(name = "raw_data", columnDefinition = "TEXT")
    private String rawData; // JSON string of original lead data
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "converted_at")
    private LocalDateTime convertedAt;
    
    // Constructors
    public SocialMediaLead() {}
    
    public SocialMediaLead(String tenantId, String platform, String platformLeadId) {
        this.tenantId = tenantId;
        this.platform = platform;
        this.platformLeadId = platformLeadId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTenantId() {
        return tenantId;
    }
    
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    
    public String getPlatform() {
        return platform;
    }
    
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
    public String getPlatformLeadId() {
        return platformLeadId;
    }
    
    public void setPlatformLeadId(String platformLeadId) {
        this.platformLeadId = platformLeadId;
    }
    
    public String getCampaignId() {
        return campaignId;
    }
    
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }
    
    public String getCampaignName() {
        return campaignName;
    }
    
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
    
    public Long getCrmLeadId() {
        return crmLeadId;
    }
    
    public void setCrmLeadId(Long crmLeadId) {
        this.crmLeadId = crmLeadId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public Integer getLeadScore() {
        return leadScore;
    }
    
    public void setLeadScore(Integer leadScore) {
        this.leadScore = leadScore;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
    
    public Long getAssignedTo() {
        return assignedTo;
    }
    
    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    public String getRawData() {
        return rawData;
    }
    
    public void setRawData(String rawData) {
        this.rawData = rawData;
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
    
    public LocalDateTime getConvertedAt() {
        return convertedAt;
    }
    
    public void setConvertedAt(LocalDateTime convertedAt) {
        this.convertedAt = convertedAt;
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}