package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.zen.entities.common.DocumentStatus;

@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    private Long quoteId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    // Business Fields
    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "document_date")
    private LocalDateTime documentDate;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    // Financial Fields
    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "discount_total")
    private Double discountTotal;

    @Column(name = "tax_total")
    private Double taxTotal;

    @Column(name = "shipping_charges")
    private Double shippingCharges;

    @Column(name = "adjustment")
    private Double adjustment;

    @Column(name = "grand_total")
    private Double grandTotal;

    // Analytics Fields
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "approver_id")
    private Long approverId;

    @Column(name = "source")
    private String source;

    @Column(name = "priority")
    private String priority;

    @Column(name = "stage")
    private String stage;

    @Column(name = "probability")
    private Integer probability;

    @Column(name = "expected_close_date")
    private LocalDateTime expectedCloseDate;

    @Column(name = "actual_close_date")
    private LocalDateTime actualCloseDate;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "quoteId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Long getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(Long updatedBy) { this.updatedBy = updatedBy; }

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

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    // Financial Fields Getters/Setters
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Double getDiscountTotal() { return discountTotal; }
    public void setDiscountTotal(Double discountTotal) { this.discountTotal = discountTotal; }

    public Double getTaxTotal() { return taxTotal; }
    public void setTaxTotal(Double taxTotal) { this.taxTotal = taxTotal; }

    public Double getShippingCharges() { return shippingCharges; }
    public void setShippingCharges(Double shippingCharges) { this.shippingCharges = shippingCharges; }

    public Double getAdjustment() { return adjustment; }
    public void setAdjustment(Double adjustment) { this.adjustment = adjustment; }

    public Double getGrandTotal() { return grandTotal; }
    public void setGrandTotal(Double grandTotal) { this.grandTotal = grandTotal; }

    // Analytics Fields Getters/Setters
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public Long getApproverId() { return approverId; }
    public void setApproverId(Long approverId) { this.approverId = approverId; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }

    public Integer getProbability() { return probability; }
    public void setProbability(Integer probability) { this.probability = probability; }

    public LocalDateTime getExpectedCloseDate() { return expectedCloseDate; }
    public void setExpectedCloseDate(LocalDateTime expectedCloseDate) { this.expectedCloseDate = expectedCloseDate; }

    public LocalDateTime getActualCloseDate() { return actualCloseDate; }
    public void setActualCloseDate(LocalDateTime actualCloseDate) { this.actualCloseDate = actualCloseDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}