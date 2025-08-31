package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "deals", indexes = {@Index(name = "idx_deal_name", columnList = "dealName")})
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"contact", "account"})
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // match DB
    private Long id;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deal_owner_id")
    private ZenUser dealOwner;
    
    @Column(name= "deal_name", nullable = false, length = 255)
    private String dealName;


    @Column(name= "next_step")
    private String nextStep;

    @Enumerated(EnumType.STRING)
    @Column(name="lead_source", length = 20)
    private LeadSource leadSource;

    @Column(precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name= "closing_date")
    private LocalDateTime closingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", foreignKey = @ForeignKey(name = "fk_deal_contact"))
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_deal_account"))
    private Account account;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private DealType type;

    public Long getDealId() {
		return id;
	}

	public void setDealId(Long dealId) {
		this.id = dealId;
	}

	public ZenUser getDealOwner() {
		return dealOwner;
	}

	public void setDealOwner(ZenUser dealOwner) {
		this.dealOwner = dealOwner;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public DealType getType() {
		return type;
	}

	public void setType(DealType type) {
		this.type = type;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public LeadSource getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(LeadSource leadSource) {
		this.leadSource = leadSource;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDateTime closingDate) {
		this.closingDate = closingDate;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getProbability() {
		return probability;
	}

	public void setProbability(Integer probability) {
		this.probability = probability;
	}

	public BigDecimal getExpectedRevenue() {
		return expectedRevenue;
	}

	public void setExpectedRevenue(BigDecimal expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}

	public String getCampaignSource() {
		return campaignSource;
	}

	public void setCampaignSource(String campaignSource) {
		this.campaignSource = campaignSource;
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

	@Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Stage stage;

    private String qualification;

    @Column(nullable = false)
    private Integer probability;

    @Column(name = "expected_revenue", precision = 15, scale = 2)
    private BigDecimal expectedRevenue;

    @Column(name = "campaign_source")  
    private String campaignSource;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum DealType {
        NEW_BUSINESS, EXISTING_BUSINESS, RENEWAL, OTHER, NEW
    }

    public enum Stage {
        PROSPECTING, QUALIFICATION, PROPOSAL, NEGOTIATION, CLOSED_WON, CLOSED_LOST
    }
    
    
}
