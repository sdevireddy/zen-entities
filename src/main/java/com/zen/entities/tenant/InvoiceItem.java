package com.zen.entities.tenant;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "document_items")
@Where(clause = "document_type = 'INVOICE'")
public class InvoiceItem extends DocumentItemBase {

    @Column(name = "document_type", insertable = false, updatable = false)
    private String documentType = "INVOICE";

    @Column(name = "document_id")
    private Long invoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", insertable = false, updatable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @PrePersist
    protected void onCreate() {
        this.documentType = "INVOICE";
        if (invoice != null) {
            this.invoiceId = invoice.getId();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.documentType = "INVOICE";
        if (invoice != null) {
            this.invoiceId = invoice.getId();
        }
    }

    // Getters and Setters
    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public Long getInvoiceId() { return invoiceId; }
    public void setInvoiceId(Long invoiceId) { 
        this.invoiceId = invoiceId;
    }

    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { 
        this.invoice = invoice;
        if (invoice != null) {
            this.invoiceId = invoice.getId();
        }
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}