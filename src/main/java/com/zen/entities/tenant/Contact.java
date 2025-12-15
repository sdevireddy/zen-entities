package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import java.time.LocalDateTime;
import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "contacts")
@ToString(exclude = {"account", "reportingTo"})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_owner_id", nullable = true, foreignKey = @ForeignKey(name = "fk_contact_owner"))
    private ZenUser contactOwner;

    @Enumerated(EnumType.STRING)
    @Column(name = "lead_source", length = 50)
    private LeadSource leadSource;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_contact_account"))
    private Account account;

    @Column(name = "vendor_name", length = 150)
    private String vendorName;

    @Column(name = "company", length = 150)
    private String company;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "department", length = 100)
    private String department;

    @Column(name = "other_phone", length = 20)
    private String otherPhone;

    @Column(name = "home_phone", length = 20)
    private String homePhone;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth; // Changed to LocalDate since SQL DATE has no time part

    @Column(name = "assistant", length = 100)
    private String assistant;

    @Column(name = "asst_phone", length = 20)
    private String asstPhone;

    @Column(name = "email_opt_out")
    private Boolean emailOptOut = false;

    @Column(name = "skype_id", length = 100)
    private String skypeId;

    @Column(name = "secondary_email", length = 150)
    private String secondaryEmail;

    @Column(name = "twitter_handle", length = 50)
    private String twitterHandle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporting_to_id", foreignKey = @ForeignKey(name = "fk_contact_reporting_to"))
    private Contact reportingTo;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void setAccountWithLink(Account account) {
        this.account = account;

        if (account != null && (account.getContacts() == null || !account.getContacts().contains(this))) {
            if (account.getContacts() == null) {
                account.setContacts(new HashSet<>()); // Initialize if null
            }
            account.getContacts().add(this);
        }
    }


	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public ZenUser getContactOwner() {
		return contactOwner;
	}

	public void setContactOwner(ZenUser contactOwner) {
		this.contactOwner = contactOwner;
	}

	public LeadSource getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(LeadSource leadSource) {
		this.leadSource = leadSource;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public String getAsstPhone() {
		return asstPhone;
	}

	public void setAsstPhone(String asstPhone) {
		this.asstPhone = asstPhone;
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

	public String getTwitterHandle() {
		return twitterHandle;
	}

	public void setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}

	public Contact getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(Contact reportingTo) {
		this.reportingTo = reportingTo;
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
    
}
