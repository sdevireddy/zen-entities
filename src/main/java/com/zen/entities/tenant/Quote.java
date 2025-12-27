package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.zen.entities.common.DocumentStatus;

@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long quoteId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Business Fields
    @Column(name = "quote_number")
    private String documentNumber;

    @Column(name = "quote_date")
    private LocalDateTime documentDate;

    @Column(name = "valid_until")
    private LocalDateTime expiryDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    // Foreign Key References
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "deal_id")
    private Long dealId;

    @Column(name = "owner_id")
    private Long ownerId;

    // Financial Fields
    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "tax_amount")
    private Double taxAmount;

    @Column(name = "total_amount")
    private Double totalAmount;

    // Additional Fields
    @Column(name = "terms_conditions", columnDefinition = "TEXT")
    private String termsConditions;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    // Restored relationships - tables will be created by V208 migration
    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuoteCampaign> campaigns;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QuoteTask> tasks;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QuoteItem> items;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QuoteComment> comments;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QuoteAttachment> attachments;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return quoteId; }
    public void setId(Long id) { this.quoteId = id; }
    
    public Long getQuoteId() { return quoteId; }
    public void setQuoteId(Long quoteId) { this.quoteId = quoteId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // Restored getters/setters for relationships
    public List<QuoteCampaign> getCampaigns() { return campaigns; }
    public void setCampaigns(List<QuoteCampaign> campaigns) { this.campaigns = campaigns; }

    public List<QuoteTask> getTasks() { return tasks; }
    public void setTasks(List<QuoteTask> tasks) { this.tasks = tasks; }

    public List<QuoteItem> getItems() { return items; }
    public void setItems(List<QuoteItem> items) { this.items = items; }

    public List<QuoteComment> getComments() { return comments; }
    public void setComments(List<QuoteComment> comments) { this.comments = comments; }

    public List<QuoteAttachment> getAttachments() { return attachments; }
    public void setAttachments(List<QuoteAttachment> attachments) { this.attachments = attachments; }

    // Business Fields Getters/Setters
    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public LocalDateTime getDocumentDate() { return documentDate; }
    public void setDocumentDate(LocalDateTime documentDate) { this.documentDate = documentDate; }

    public LocalDateTime getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDateTime expiryDate) { this.expiryDate = expiryDate; }

    public DocumentStatus getStatus() { return status; }
    public void setStatus(DocumentStatus status) { this.status = status; }

    public Long getCustomerId() { return accountId; } // For backward compatibility
    public void setCustomerId(Long customerId) { this.accountId = customerId; }

    public String getCustomerName() { return null; } // Not stored in quotes table
    public void setCustomerName(String customerName) { /* Not stored */ }

    public String getCustomerEmail() { return null; } // Not stored in quotes table
    public void setCustomerEmail(String customerEmail) { /* Not stored */ }

    // Foreign Key References Getters/Setters
    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }

    public Long getContactId() { return contactId; }
    public void setContactId(Long contactId) { this.contactId = contactId; }

    public Long getDealId() { return dealId; }
    public void setDealId(Long dealId) { this.dealId = dealId; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    // Financial Fields Getters/Setters
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Double getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(Double discountAmount) { this.discountAmount = discountAmount; }

    public Double getDiscountTotal() { return discountAmount; } // For backward compatibility
    public void setDiscountTotal(Double discountTotal) { this.discountAmount = discountTotal; }

    public Double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(Double taxAmount) { this.taxAmount = taxAmount; }

    public Double getTaxTotal() { return taxAmount; } // For backward compatibility
    public void setTaxTotal(Double taxTotal) { this.taxAmount = taxTotal; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Double getGrandTotal() { return totalAmount; } // For backward compatibility
    public void setGrandTotal(Double grandTotal) { this.totalAmount = grandTotal; }

    // Legacy getters for fields that don't exist in database
    public Double getShippingCharges() { return 0.0; }
    public void setShippingCharges(Double shippingCharges) { /* Not stored */ }

    public Double getAdjustment() { return 0.0; }
    public void setAdjustment(Double adjustment) { /* Not stored */ }

    public Long getApproverId() { return null; }
    public void setApproverId(Long approverId) { /* Not stored */ }

    public String getSource() { return null; }
    public void setSource(String source) { /* Not stored */ }

    public String getPriority() { return null; }
    public void setPriority(String priority) { /* Not stored */ }

    public String getStage() { return null; }
    public void setStage(String stage) { /* Not stored */ }

    public Integer getProbability() { return null; }
    public void setProbability(Integer probability) { /* Not stored */ }

    public LocalDateTime getExpectedCloseDate() { return null; }
    public void setExpectedCloseDate(LocalDateTime expectedCloseDate) { /* Not stored */ }

    public LocalDateTime getActualCloseDate() { return null; }
    public void setActualCloseDate(LocalDateTime actualCloseDate) { /* Not stored */ }

    public String getCurrencyCode() { return "USD"; } // Default value
    public void setCurrencyCode(String currencyCode) { /* Not stored */ }

    public String getTitle() { return documentNumber; } // Use document number as title
    public void setTitle(String title) { /* Not stored */ }

    // Additional Fields Getters/Setters
    public String getTermsConditions() { return termsConditions; }
    public void setTermsConditions(String termsConditions) { this.termsConditions = termsConditions; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
}