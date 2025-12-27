package com.zen.entities.tenant;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "document_items")
@Where(clause = "document_type = 'QUOTE'")
public class QuoteItem extends DocumentItemBase {

    @Column(name = "document_type", insertable = false, updatable = false)
    private String documentType = "QUOTE";

    @Column(name = "document_id")
    private Long quoteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", insertable = false, updatable = false)
    private Quote quote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @PrePersist
    protected void onCreate() {
        this.documentType = "QUOTE";
        if (quote != null) {
            this.quoteId = quote.getId();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.documentType = "QUOTE";
        if (quote != null) {
            this.quoteId = quote.getId();
        }
    }

    // Getters and Setters
    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public Long getQuoteId() { return quoteId; }
    public void setQuoteId(Long quoteId) { 
        this.quoteId = quoteId;
    }

    public Quote getQuote() { return quote; }
    public void setQuote(Quote quote) { 
        this.quote = quote;
        if (quote != null) {
            this.quoteId = quote.getId();
        }
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}