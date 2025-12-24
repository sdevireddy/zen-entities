package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "campaigns")
public class Campaign {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "campaign_name", nullable = false)
    private String campaignName;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "campaign_type")
    @Enumerated(EnumType.STRING)
    private CampaignType campaignType = CampaignType.EMAIL;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CampaignStatus status = CampaignStatus.DRAFT;
    
    @Column(name = "start_date")
    private LocalDateTime startDate;
    
    @Column(name = "end_date")
    private LocalDateTime endDate;
    
    @Column(name = "budget", columnDefinition = "DECIMAL(15,2)")
    private BigDecimal budget;
    
    @Column(name = "actual_cost", columnDefinition = "DECIMAL(15,2)")
    private BigDecimal actualCost = BigDecimal.ZERO;
    
    @Column(name = "expected_revenue", columnDefinition = "DECIMAL(15,2)")
    private BigDecimal expectedRevenue;
    
    // Social Media Campaign Analytics
    @Column(name = "total_sent")
    private Integer totalSent = 0;
    
    @Column(name = "total_delivered")
    private Integer totalDelivered = 0;
    
    @Column(name = "total_read")
    private Integer totalRead = 0;
    
    @Column(name = "total_replied")
    private Integer totalReplied = 0;
    
    @Column(name = "platforms", columnDefinition = "TEXT")
    private String platforms; // JSON: ["whatsapp","facebook"]
    
    @Column(name = "owner_id")
    private Long ownerId;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum CampaignType { EMAIL, SMS, SOCIAL, WEBINAR, TRADE_SHOW, ADVERTISEMENT }
    public enum CampaignStatus { DRAFT, ACTIVE, PAUSED, COMPLETED, CANCELLED }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public CampaignType getCampaignType() { return campaignType; }
    public void setCampaignType(CampaignType campaignType) { this.campaignType = campaignType; }
    
    public CampaignStatus getStatus() { return status; }
    public void setStatus(CampaignStatus status) { this.status = status; }
    
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    
    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }
    
    public BigDecimal getActualCost() { return actualCost; }
    public void setActualCost(BigDecimal actualCost) { this.actualCost = actualCost; }
    
    public BigDecimal getExpectedRevenue() { return expectedRevenue; }
    public void setExpectedRevenue(BigDecimal expectedRevenue) { this.expectedRevenue = expectedRevenue; }
    
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public Integer getTotalSent() { return totalSent; }
    public void setTotalSent(Integer totalSent) { this.totalSent = totalSent; }
    
    public Integer getTotalDelivered() { return totalDelivered; }
    public void setTotalDelivered(Integer totalDelivered) { this.totalDelivered = totalDelivered; }
    
    public Integer getTotalRead() { return totalRead; }
    public void setTotalRead(Integer totalRead) { this.totalRead = totalRead; }
    
    public Integer getTotalReplied() { return totalReplied; }
    public void setTotalReplied(Integer totalReplied) { this.totalReplied = totalReplied; }
    
    public String getPlatforms() { return platforms; }
    public void setPlatforms(String platforms) { this.platforms = platforms; }
}