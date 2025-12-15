package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "keyword_performance")
public class KeywordPerformance {
    
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
    
    @Column(name = "keyword", nullable = false)
    private String keyword;
    
    @Column(name = "match_type")
    private String matchType; // EXACT, PHRASE, BROAD
    
    @Column(name = "impressions")
    private Long impressions = 0L;
    
    @Column(name = "clicks")
    private Long clicks = 0L;
    
    @Column(name = "cost", precision = 10, scale = 2)
    private BigDecimal cost = BigDecimal.ZERO;
    
    @Column(name = "conversions")
    private Long conversions = 0L;
    
    @Column(name = "conversion_value", precision = 10, scale = 2)
    private BigDecimal conversionValue = BigDecimal.ZERO;
    
    @Column(name = "ctr", precision = 5, scale = 4) // Click-through rate
    private BigDecimal ctr = BigDecimal.ZERO;
    
    @Column(name = "cpc", precision = 10, scale = 2) // Cost per click
    private BigDecimal cpc = BigDecimal.ZERO;
    
    @Column(name = "cpa", precision = 10, scale = 2) // Cost per acquisition
    private BigDecimal cpa = BigDecimal.ZERO;
    
    @Column(name = "quality_score")
    private Integer qualityScore;
    
    @Column(name = "avg_position", precision = 3, scale = 1)
    private BigDecimal avgPosition;
    
    @Column(name = "search_volume")
    private Long searchVolume;
    
    @Column(name = "competition_level")
    private String competitionLevel; // LOW, MEDIUM, HIGH
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public KeywordPerformance() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public KeywordPerformance(String tenantId, String keyword, LocalDate date) {
        this();
        this.tenantId = tenantId;
        this.keyword = keyword;
        this.date = date;
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
    
    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }
    
    public Long getImpressions() { return impressions; }
    public void setImpressions(Long impressions) { this.impressions = impressions; }
    
    public Long getClicks() { return clicks; }
    public void setClicks(Long clicks) { this.clicks = clicks; }
    
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    
    public Long getConversions() { return conversions; }
    public void setConversions(Long conversions) { this.conversions = conversions; }
    
    public BigDecimal getConversionValue() { return conversionValue; }
    public void setConversionValue(BigDecimal conversionValue) { this.conversionValue = conversionValue; }
    
    public BigDecimal getCtr() { return ctr; }
    public void setCtr(BigDecimal ctr) { this.ctr = ctr; }
    
    public BigDecimal getCpc() { return cpc; }
    public void setCpc(BigDecimal cpc) { this.cpc = cpc; }
    
    public BigDecimal getCpa() { return cpa; }
    public void setCpa(BigDecimal cpa) { this.cpa = cpa; }
    
    public Integer getQualityScore() { return qualityScore; }
    public void setQualityScore(Integer qualityScore) { this.qualityScore = qualityScore; }
    
    public BigDecimal getAvgPosition() { return avgPosition; }
    public void setAvgPosition(BigDecimal avgPosition) { this.avgPosition = avgPosition; }
    
    public Long getSearchVolume() { return searchVolume; }
    public void setSearchVolume(Long searchVolume) { this.searchVolume = searchVolume; }
    
    public String getCompetitionLevel() { return competitionLevel; }
    public void setCompetitionLevel(String competitionLevel) { this.competitionLevel = competitionLevel; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Calculated fields
    public BigDecimal calculateCTR() {
        if (impressions == null || impressions == 0) return BigDecimal.ZERO;
        return BigDecimal.valueOf(clicks).divide(BigDecimal.valueOf(impressions), 4, BigDecimal.ROUND_HALF_UP);
    }
    
    public BigDecimal calculateCPC() {
        if (clicks == null || clicks == 0) return BigDecimal.ZERO;
        return cost.divide(BigDecimal.valueOf(clicks), 2, BigDecimal.ROUND_HALF_UP);
    }
    
    public BigDecimal calculateCPA() {
        if (conversions == null || conversions == 0) return BigDecimal.ZERO;
        return cost.divide(BigDecimal.valueOf(conversions), 2, BigDecimal.ROUND_HALF_UP);
    }
}