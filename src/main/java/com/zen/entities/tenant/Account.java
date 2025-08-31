package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
    name = "accounts",
    indexes = {@Index(name = "idx_account_name", columnList = "account_name")}
)
@ToString(exclude = {"contacts", "deals", "childAccounts", "parentAccount"})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_owner_id", foreignKey = @ForeignKey(name = "fk_account_owner"))
    private ZenUser accountOwner;

    @Column(name = "account_name", nullable = false, unique = true, length = 255)
    private String accountName;

    @Column(name = "account_site")
    private String accountSite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_account_id", foreignKey = @ForeignKey(name = "fk_account_parent"))
    private Account parentAccount;

    @OneToMany(mappedBy = "parentAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> childAccounts = new ArrayList<>();

    @Column(name = "account_number", unique = true, length = 50)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", length = 20)
    private AccountType accountType;

    private String industry;

    @Column(name = "annual_revenue", precision = 15, scale = 2)
    private BigDecimal annualRevenue;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating", length = 10)
    private Rating rating;

    private String phone;
    private String fax;
    private String website;

    @Column(name = "ticker_symbol")
    private String tickerSymbol;

    @Enumerated(EnumType.STRING)
    @Column(name = "ownership", length = 20)
    private Ownership ownership;

    @Column(name = "sic_code", length = 50)
    private String sicCode;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void setLastUpdated() {
        this.updatedAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts = new HashSet<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deal> deals = new ArrayList<>();
    
    

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            contact.setAccount(this); // ensures the Contact side is updated
        }
    }

    public void removeContact(Contact contact) {
        if (contacts.contains(contact)) {
            contacts.remove(contact);
            contact.setAccount(null);
        }
    }
    public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	// For Spring Data compatibility
	public Long getId() {
		return accountId;
	}
	
	public void setId(Long id) {
		this.accountId = id;
	}


	public ZenUser getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(ZenUser accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountSite() {
		return accountSite;
	}

	public void setAccountSite(String accountSite) {
		this.accountSite = accountSite;
	}

	public List<Account> getChildAccounts() {
		return childAccounts;
	}

	public void setChildAccounts(List<Account> childAccounts) {
		this.childAccounts = childAccounts;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public BigDecimal getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(BigDecimal annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public Ownership getOwnership() {
		return ownership;
	}

	public void setOwnership(Ownership ownership) {
		this.ownership = ownership;
	}

	public String getSicCode() {
		return sicCode;
	}

	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
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

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}


    public void addDeal(Deal deal) {
        deals.add(deal);
        deal.setAccount(this);
    }

    public void removeDeal(Deal deal) {
        deals.remove(deal);
        deal.setAccount(null);
    }


    public enum AccountType { CUSTOMER, PARTNER, VENDOR, PROSPECT, OTHER }
    public enum Rating { HOT, WARM, COLD }
    public enum Ownership { PUBLIC, PRIVATE, SUBSIDIARY, OTHER }
    
    public Account getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(Account parentAccount) {
        this.parentAccount = parentAccount;
    }

    public void addChildAccount(Account child) {
        if (!childAccounts.contains(child)) {
            childAccounts.add(child);
            child.setParentAccount(this);
        }
    }

    public void removeChildAccount(Account child) {
        if (childAccounts.contains(child)) {
            childAccounts.remove(child);
            child.setParentAccount(null);
        }
    }



}
