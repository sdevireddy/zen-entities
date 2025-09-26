package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import java.time.LocalDateTime;
import java.util.Objects;

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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "leads")

@NoArgsConstructor

public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_owner_id")
    private ZenUser leadOwner;
    private String company;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String title;
    private String email;
    private String fax;
    private String mobile;
    private String website;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "lead_source")
    private LeadSource leadSource;
    @Enumerated(EnumType.STRING)
    @Column(name = "lead_status")
    private LeadStatus leadStatus;
    private String industry;
    @Column(name = "no_of_employees")
    private Integer noOfEmployees;
    @Column(name = "annual_revenue")
    private Double annualRevenue;
    private String rating;
    @Column(name = "email_opt_out")
    private Boolean emailOptOut = false;

    @Column(name = "skype_id")
    private String skypeId;
    @Column(name = "secondary_email")
    private String secondaryEmail;
    private String twitter;
    private String description;
    private Boolean converted = false;
    @Column(name = "address_line1")
    private String addressLine1;
    @Column(name = "address_line2")
    private String addressLine2;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    private String country;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "lead_score")
    private Integer leadScore = 0;
    @Column(name = "score_reason")
    private String scoreReason;
    @Column(name = "qualified_date")
    private LocalDateTime qualifiedDate;

    @Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	 @Column(name = "updated_at")
	private LocalDateTime updatedAt;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ZenUser getLeadOwner() {
		return leadOwner;
	}
	public void setLeadOwner(ZenUser leadOwner) {
		this.leadOwner = leadOwner;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public LeadSource getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(LeadSource leadSource) {
		this.leadSource = leadSource;
	}

	public LeadStatus getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(LeadStatus status) {
		this.leadStatus = status;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(Integer noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	public Double getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(Double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Boolean getEmailOptOut() {
		return emailOptOut;
	}
	public void setEmailOptOut(Boolean emailOptOut) {
		this.emailOptOut = emailOptOut;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(
	        id,
	        company,
	        firstName,
	        lastName,
	        title,
	        email,
	        fax,
	        mobile,
	        website,
	        leadSource,
	        leadStatus,
	        industry,
	        noOfEmployees,
	        annualRevenue,
	        rating,
	        emailOptOut,
	        skypeId,
	        secondaryEmail,
	        twitter,
	        description,
	        converted,
	        leadOwner != null ? leadOwner.getId() : null
	    );
	}

    
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    Lead other = (Lead) obj;
	    return Objects.equals(id, other.id)
	            && Objects.equals(company, other.company)
	            && Objects.equals(firstName, other.firstName)
	            && Objects.equals(lastName, other.lastName)
	            && Objects.equals(title, other.title)
	            && Objects.equals(email, other.email)
	            && Objects.equals(fax, other.fax)
	            && Objects.equals(mobile, other.mobile)
	            && Objects.equals(website, other.website)
	            && Objects.equals(leadSource, other.leadSource)
	            && Objects.equals(leadStatus, other.leadStatus)
	            && Objects.equals(industry, other.industry)
	            && Objects.equals(noOfEmployees, other.noOfEmployees)
	            && Objects.equals(annualRevenue, other.annualRevenue)
	            && Objects.equals(rating, other.rating)
	            && Objects.equals(emailOptOut, other.emailOptOut)
	            && Objects.equals(skypeId, other.skypeId)
	            && Objects.equals(secondaryEmail, other.secondaryEmail)
	            && Objects.equals(twitter, other.twitter)
	            && Objects.equals(description, other.description)
	            && Objects.equals(converted, other.converted)
	            && Objects.equals(
	                   leadOwner != null ? leadOwner.getId() : null,
	                   other.leadOwner != null ? other.leadOwner.getId() : null
	               );
	}

	public Boolean getConverted() {
		return converted;
	}
	public void setConverted(Boolean converted) {
		this.converted = converted;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getLeadScore() {
		return leadScore;
	}
	public void setLeadScore(Integer leadScore) {
		this.leadScore = leadScore;
	}
	public String getScoreReason() {
		return scoreReason;
	}
	public void setScoreReason(String scoreReason) {
		this.scoreReason = scoreReason;
	}
	public LocalDateTime getQualifiedDate() {
		return qualifiedDate;
	}
	public void setQualifiedDate(LocalDateTime qualifiedDate) {
		this.qualifiedDate = qualifiedDate;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}