package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "social_media_leads", indexes = {
    @Index(name = "idx_tenant_platform", columnList = "tenant_id, platform"),
    @Index(name = "idx_platform_lead_id", columnList = "platform_lead_id"),
    @Index(name = "idx_status", columnList = "status"),
    @Index(name = "idx_lead_score", columnList = "lead_score"),
    @Index(name = "idx_created_at", columnList = "created_at")
})
public class SocialMediaLead {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tenant_id", nullable = false)
    private String tenantId;
    
    @Column(name = "platform", nullable = false)
    private String platform; // facebook, linkedin, twitter, instagram, tiktok, youtube
    
    @Column(name = "platform_lead_id", nullable = false)
    private String platformLeadId;
    
    @Column(name = "campaign_id")
    private String campaignId;
    
    @Column(name = "campaign_name")
    private String campaignName;
    
    @Column(name = "ad_set_id")
    private String adSetId;
    
    @Column(name = "ad_set_name")
    private String adSetName;
    
    @Column(name = "ad_id")
    private String adId;
    
    @Column(name = "ad_name")
    private String adName;
    
    @Column(name = "crm_lead_id")
    private Long crmLeadId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "job_title")
    private String jobTitle;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "lead_score")
    private Integer leadScore;
    
    @Column(name = "status")
    private String status = "NEW"; // NEW, CONTACTED, QUALIFIED, NURTURED, CONVERTED, REJECTED, LOST
    
    @Column(name = "lead_source")
    private String leadSource; // organic, paid, referral
    
    @Column(name = "lead_medium")
    private String leadMedium; // social, search, display, video
    
    @Column(name = "utm_source")
    private String utmSource;
    
    @Column(name = "utm_medium")
    private String utmMedium;
    
    @Column(name = "utm_campaign")
    private String utmCampaign;
    
    @Column(name = "utm_content")
    private String utmContent;
    
    @Column(name = "utm_term")
    private String utmTerm;
    
    @Column(name = "assigned_to")
    private Long assignedTo;
    
    @Column(name = "priority")
    private String priority = "MEDIUM"; // LOW, MEDIUM, HIGH, URGENT
    
    @Column(name = "interest_level")
    private String interestLevel; // LOW, MEDIUM, HIGH
    
    @Column(name = "budget_range")
    private String budgetRange;
    
    @Column(name = "timeline")
    private String timeline; // IMMEDIATE, 1_MONTH, 3_MONTHS, 6_MONTHS, 1_YEAR
    
    @Column(name = "lead_value", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal leadValue;
    
    @Column(name = "cost_per_lead", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal costPerLead;
    
    @Column(name = "conversion_value", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal conversionValue;
    
    @Column(name = "tags", columnDefinition = "TEXT")
    private String tags; // Comma-separated tags
    
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
    
    @Column(name = "custom_fields", columnDefinition = "JSON")
    private String customFields;
    
    @Column(name = "raw_data", columnDefinition = "TEXT")
    private String rawData; // JSON string of original lead data
    
    @Column(name = "last_contacted_at")
    private LocalDateTime lastContactedAt;
    
    @Column(name = "next_follow_up_at")
    private LocalDateTime nextFollowUpAt;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "converted_at")
    private LocalDateTime convertedAt;
    
    @Column(name = "qualified_at")
    private LocalDateTime qualifiedAt;
    
    // Constructors
    public SocialMediaLead() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public SocialMediaLead(String tenantId, String platform, String platformLeadId) {
        this();
        this.tenantId = tenantId;
        this.platform = platform;
        this.platformLeadId = platformLeadId;
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
    
    // Additional getters and setters for new fields
    public String getAdSetId() { return adSetId; }
    public void setAdSetId(String adSetId) { this.adSetId = adSetId; }
    
    public String getAdSetName() { return adSetName; }
    public void setAdSetName(String adSetName) { this.adSetName = adSetName; }
    
    public String getAdId() { return adId; }
    public void setAdId(String adId) { this.adId = adId; }
    
    public String getAdName() { return adName; }
    public void setAdName(String adName) { this.adName = adName; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getLeadSource() { return leadSource; }
    public void setLeadSource(String leadSource) { this.leadSource = leadSource; }
    
    public String getLeadMedium() { return leadMedium; }
    public void setLeadMedium(String leadMedium) { this.leadMedium = leadMedium; }
    
    public String getUtmSource() { return utmSource; }
    public void setUtmSource(String utmSource) { this.utmSource = utmSource; }
    
    public String getUtmMedium() { return utmMedium; }
    public void setUtmMedium(String utmMedium) { this.utmMedium = utmMedium; }
    
    public String getUtmCampaign() { return utmCampaign; }
    public void setUtmCampaign(String utmCampaign) { this.utmCampaign = utmCampaign; }
    
    public String getUtmContent() { return utmContent; }
    public void setUtmContent(String utmContent) { this.utmContent = utmContent; }
    
    public String getUtmTerm() { return utmTerm; }
    public void setUtmTerm(String utmTerm) { this.utmTerm = utmTerm; }
    
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    
    public String getInterestLevel() { return interestLevel; }
    public void setInterestLevel(String interestLevel) { this.interestLevel = interestLevel; }
    
    public String getBudgetRange() { return budgetRange; }
    public void setBudgetRange(String budgetRange) { this.budgetRange = budgetRange; }
    
    public String getTimeline() { return timeline; }
    public void setTimeline(String timeline) { this.timeline = timeline; }
    
    public BigDecimal getLeadValue() { return leadValue; }
    public void setLeadValue(BigDecimal leadValue) { this.leadValue = leadValue; }
    
    public BigDecimal getCostPerLead() { return costPerLead; }
    public void setCostPerLead(BigDecimal costPerLead) { this.costPerLead = costPerLead; }
    
    public BigDecimal getConversionValue() { return conversionValue; }
    public void setConversionValue(BigDecimal conversionValue) { this.conversionValue = conversionValue; }
    
    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getCustomFields() { return customFields; }
    public void setCustomFields(String customFields) { this.customFields = customFields; }
    
    public LocalDateTime getLastContactedAt() { return lastContactedAt; }
    public void setLastContactedAt(LocalDateTime lastContactedAt) { this.lastContactedAt = lastContactedAt; }
    
    public LocalDateTime getNextFollowUpAt() { return nextFollowUpAt; }
    public void setNextFollowUpAt(LocalDateTime nextFollowUpAt) { this.nextFollowUpAt = nextFollowUpAt; }
    
    public LocalDateTime getQualifiedAt() { return qualifiedAt; }
    public void setQualifiedAt(LocalDateTime qualifiedAt) { this.qualifiedAt = qualifiedAt; }
    
    // Helper methods
    public boolean isHighPriority() {
        return "HIGH".equals(priority) || "URGENT".equals(priority);
    }
    
    public boolean isQualified() {
        return "QUALIFIED".equals(status) || "CONVERTED".equals(status);
    }
    
    public boolean needsFollowUp() {
        return nextFollowUpAt != null && nextFollowUpAt.isBefore(LocalDateTime.now());
    }
    
    public boolean isHotLead() {
        return leadScore != null && leadScore >= 80;
    }
    
    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return name != null ? name : "";
    }
    
    public void markAsContacted() {
        this.lastContactedAt = LocalDateTime.now();
        if ("NEW".equals(this.status)) {
            this.status = "CONTACTED";
        }
    }
    
    public void markAsQualified() {
        this.status = "QUALIFIED";
        this.qualifiedAt = LocalDateTime.now();
    }
    
    public void markAsConverted() {
        this.status = "CONVERTED";
        this.convertedAt = LocalDateTime.now();
    }
    
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}