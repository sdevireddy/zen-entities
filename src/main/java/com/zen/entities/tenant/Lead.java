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
@AllArgsConstructor

public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_owner_id")
    private ZenUser leadOwner;
    private String company;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String fax;
    private String mobile;
    private String website;
    @Enumerated(EnumType.STRING)
    private LeadSource leadSource;
    @Enumerated(EnumType.STRING)
    private LeadStatus leadStatus;
    private String industry;
    private Integer noOfEmployees;
    private Double annualRevenue;
    private String rating;
    @Column(name = "email_opt_out")
    private Boolean emailOptOut = false;

    private String skypeId;
    private String secondaryEmail;
    private String twitter;
    private String description;
    private Boolean converted = false;

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

	@PrePersist
	protected void onCreate() {
	    this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
	    this.updatedAt = LocalDateTime.now();
	}
}