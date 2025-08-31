package com.zen.entities.tenant;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quotes")
@AttributeOverride(name = "id", column = @Column(name = "quote_id"))
public class Quote extends DocumentBase {

    // --- Customer / Contact ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;   // Customer company

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;   // Contact person

    // --- Ownership & Approval ---
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "approver_id")
    private Long approverId;

    @Column(name = "converted_sales_order_id")
    private Long convertedSalesOrderId;

    // --- Currency & Region ---
    @Column(name = "currency_code", length = 10)
    private String currencyCode;

    @Column(name = "exchange_rate")
    private Double exchangeRate;

    @Column(name = "region_tax_type", length = 50)
    private String regionTaxType;

    // --- Custom fields (for Zoho-like flexibility) ---
    @Column(name = "extra_fields", columnDefinition = "TEXT")
    private String extraFieldsJson;

    // --- Relationships ---
    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<QuoteItem> items;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<QuoteVersion> versions;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<QuoteComment> comments;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<QuoteAttachment> attachments;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<QuoteTask> tasks;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<QuoteCampaign> campaigns;

    // --- Getters & Setters ---
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public Long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    public Long getApproverId() {
        return approverId;
    }
    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }
    public Long getConvertedSalesOrderId() {
        return convertedSalesOrderId;
    }
    public void setConvertedSalesOrderId(Long convertedSalesOrderId) {
        this.convertedSalesOrderId = convertedSalesOrderId;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public Double getExchangeRate() {
        return exchangeRate;
    }
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    public String getRegionTaxType() {
        return regionTaxType;
    }
    public void setRegionTaxType(String regionTaxType) {
        this.regionTaxType = regionTaxType;
    }
    public String getExtraFieldsJson() {
        return extraFieldsJson;
    }
    public void setExtraFieldsJson(String extraFieldsJson) {
        this.extraFieldsJson = extraFieldsJson;
    }
    public List<QuoteItem> getItems() {
        return items;
    }
    public void setItems(List<QuoteItem> items) {
        this.items = items;
    }
    public List<QuoteVersion> getVersions() {
        return versions;
    }
    public void setVersions(List<QuoteVersion> versions) {
        this.versions = versions;
    }
    public List<QuoteComment> getComments() {
        return comments;
    }
    public void setComments(List<QuoteComment> comments) {
        this.comments = comments;
    }
    public List<QuoteAttachment> getAttachments() {
        return attachments;
    }
    public void setAttachments(List<QuoteAttachment> attachments) {
        this.attachments = attachments;
    }
    public List<QuoteTask> getTasks() {
        return tasks;
    }
    public void setTasks(List<QuoteTask> tasks) {
        this.tasks = tasks;
    }
    public List<QuoteCampaign> getCampaigns() {
        return campaigns;
    }
    public void setCampaigns(List<QuoteCampaign> campaigns) {
        this.campaigns = campaigns;
    }

    // Helpers
    public void addCampaign(QuoteCampaign campaign) {
        campaigns.add(campaign);
        campaign.setQuote(this);
    }
    public void removeCampaign(QuoteCampaign campaign) {
        campaigns.remove(campaign);
        campaign.setQuote(null);
    }
}
