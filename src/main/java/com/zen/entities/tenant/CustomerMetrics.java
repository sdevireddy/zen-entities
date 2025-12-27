package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_metrics")
public class CustomerMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_id", nullable = false)
    private Long contactId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", insertable = false, updatable = false)
    private Contact contact;

    @Column(name = "lifetime_value", precision = 15, scale = 2)
    private BigDecimal lifetimeValue = BigDecimal.ZERO;

    @Column(name = "satisfaction_score")
    private Integer satisfactionScore = 0;

    @Column(name = "customer_since")
    private LocalDate customerSince;

    @Column(name = "last_interaction")
    private LocalDateTime lastInteraction;

    @Enumerated(EnumType.STRING)
    @Column(name = "engagement_level")
    private EngagementLevel engagementLevel = EngagementLevel.MEDIUM;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship_strength")
    private RelationshipStrength relationshipStrength = RelationshipStrength.GOOD;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_stage")
    private CustomerStage customerStage = CustomerStage.CUSTOMER;

    @Column(name = "health_score")
    private Integer healthScore = 75;

    @Column(name = "response_rate", precision = 5, scale = 2)
    private BigDecimal responseRate = BigDecimal.ZERO;

    @Column(name = "product_adoption_score")
    private Integer productAdoptionScore = 0;

    @Column(name = "support_ticket_count")
    private Integer supportTicketCount = 0;

    @Column(name = "roi_achieved", precision = 10, scale = 2)
    private BigDecimal roiAchieved = BigDecimal.ZERO;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    // Enums
    public enum EngagementLevel {
        HIGH, MEDIUM, LOW
    }

    public enum RelationshipStrength {
        EXCELLENT, GOOD, FAIR, POOR
    }

    public enum CustomerStage {
        PROSPECT, CUSTOMER, ADVOCATE
    }

    // Constructors
    public CustomerMetrics() {}

    public CustomerMetrics(Long contactId) {
        this.contactId = contactId;
        this.customerSince = LocalDate.now();
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

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public BigDecimal getLifetimeValue() {
        return lifetimeValue;
    }

    public void setLifetimeValue(BigDecimal lifetimeValue) {
        this.lifetimeValue = lifetimeValue;
    }

    public Integer getSatisfactionScore() {
        return satisfactionScore;
    }

    public void setSatisfactionScore(Integer satisfactionScore) {
        this.satisfactionScore = satisfactionScore;
    }

    public LocalDate getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(LocalDate customerSince) {
        this.customerSince = customerSince;
    }

    public LocalDateTime getLastInteraction() {
        return lastInteraction;
    }

    public void setLastInteraction(LocalDateTime lastInteraction) {
        this.lastInteraction = lastInteraction;
    }

    public EngagementLevel getEngagementLevel() {
        return engagementLevel;
    }

    public void setEngagementLevel(EngagementLevel engagementLevel) {
        this.engagementLevel = engagementLevel;
    }

    public RelationshipStrength getRelationshipStrength() {
        return relationshipStrength;
    }

    public void setRelationshipStrength(RelationshipStrength relationshipStrength) {
        this.relationshipStrength = relationshipStrength;
    }

    public CustomerStage getCustomerStage() {
        return customerStage;
    }

    public void setCustomerStage(CustomerStage customerStage) {
        this.customerStage = customerStage;
    }

    public Integer getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(Integer healthScore) {
        this.healthScore = healthScore;
    }

    public BigDecimal getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(BigDecimal responseRate) {
        this.responseRate = responseRate;
    }

    public Integer getProductAdoptionScore() {
        return productAdoptionScore;
    }

    public void setProductAdoptionScore(Integer productAdoptionScore) {
        this.productAdoptionScore = productAdoptionScore;
    }

    public Integer getSupportTicketCount() {
        return supportTicketCount;
    }

    public void setSupportTicketCount(Integer supportTicketCount) {
        this.supportTicketCount = supportTicketCount;
    }

    public BigDecimal getRoiAchieved() {
        return roiAchieved;
    }

    public void setRoiAchieved(BigDecimal roiAchieved) {
        this.roiAchieved = roiAchieved;
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}