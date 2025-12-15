package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "google_ads_leads")
public class GoogleAdsLead {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tenant_id", nullable = false)
    private String tenantId;
    
    @Column(name = "google_ads_account_id")
    private Long googleAdsAccountId;
    
    @Column(name = "campaign_id")
    private String campaignId;
    
    @Column(name = "campaign_name")
    private String campaignName;
    
    @Column(name = "ad_group_id")
    private String adGroupId;
    
    @Column(name = "ad_group_name")
    private String adGroupName;
    
    @Column(name = "keyword")
    private String keyword;
    
    @Column(name = "lead_form_id")
    private String leadFormId;
    
    @Column(name = "google_lead_id", unique = true)
    private String googleLeadId;
    
    @Column(name = "name")
    private String name;
    
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
    
    @Column(name = "lead_score")
    private Integer leadScore;
    
    @Column(name = "status")
    private String status = "NEW"; // NEW, CONTACTED, QUALIFIED, CONVERTED, REJECTED
    
    @Column(name = "source_url")
    private String sourceUrl;
    
    @Column(name = "landing_page_url")
    private String landingPageUrl;
    
    @Column(name = "cost_per_lead", precision = 10, scale = 2)
    private BigDecimal costPerLead;
    
    @Column(name = "conversion_value", precision = 10, scale = 2)
    private BigDecimal conversionValue;
    
    @Column(name = "crm_lead_id")
    private Long crmLeadId;
    
    @Column(name = "assigned_to")
    private Long assignedTo;
    
    @Column(name = "raw_data", columnDefinition = "TEXT")
    private String rawData; // JSON string of original Google Ads lead data
    
    @Column(name = "custom_fields", columnDefinition = "JSON")
    private String customFields;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "converted_at")
    private LocalDateTime convertedAt;
    
    @Column(name = "contacted_at")
    private LocalDateTime contactedAt;
    
    // Constructors
    public GoogleAdsLead() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public GoogleAdsLead(String tenantId, String googleLeadId) {
        this();
        this.tenantId = tenantId;
        this.googleLeadId = googleLeadId;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    
    public Long getGoogleAdsAccountId() { return googleAdsAccountId; }
    public void setGoogleAdsAccountId(Long googleAdsAccountId) { this.googleAdsAccountId = googleAdsAccountId; }
    
    public String getCampaignId() { return campaignId; }
    public void setCampaignId(String campaignId) { this.campaignId = campaignId; }
    
    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
    
    public String getAdGroupId() { return adGroupId; }
    public void setAdGroupId(String adGroupId) { this.adGroupId = adGroupId; }
    
    public String getAdGroupName() { return adGroupName; }
    public void setAdGroupName(String adGroupName) { this.adGroupName = adGroupName; }
    
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
    
    public String getLeadFormId() { return leadFormId; }
    public void setLeadFormId(String leadFormId) { this.leadFormId = leadFormId; }
    
    public String getGoogleLeadId() { return googleLeadId; }
    public void setGoogleLeadId(String googleLeadId) { this.googleLeadId = googleLeadId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public Integer getLeadScore() { return leadScore; }
    public void setLeadScore(Integer leadScore) { this.leadScore = leadScore; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getSourceUrl() { return sourceUrl; }
    public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }
    
    public String getLandingPageUrl() { return landingPageUrl; }
    public void setLandingPageUrl(String landingPageUrl) { this.landingPageUrl = landingPageUrl; }
    
    public BigDecimal getCostPerLead() { return costPerLead; }
    public void setCostPerLead(BigDecimal costPerLead) { this.costPerLead = costPerLead; }
    
    public BigDecimal getConversionValue() { return conversionValue; }
    public void setConversionValue(BigDecimal conversionValue) { this.conversionValue = conversionValue; }
    
    public Long getCrmLeadId() { return crmLeadId; }
    public void setCrmLeadId(Long crmLeadId) { this.crmLeadId = crmLeadId; }
    
    public Long getAssignedTo() { return assignedTo; }
    public void setAssignedTo(Long assignedTo) { this.assignedTo = assignedTo; }
    
    public String getRawData() { return rawData; }
    public void setRawData(String rawData) { this.rawData = rawData; }
    
    public String getCustomFields() { return customFields; }
    public void setCustomFields(String customFields) { this.customFields = customFields; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public LocalDateTime getConvertedAt() { return convertedAt; }
    public void setConvertedAt(LocalDateTime convertedAt) { this.convertedAt = convertedAt; }
    
    public LocalDateTime getContactedAt() { return contactedAt; }
    public void setContactedAt(LocalDateTime contactedAt) { this.contactedAt = contactedAt; }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}