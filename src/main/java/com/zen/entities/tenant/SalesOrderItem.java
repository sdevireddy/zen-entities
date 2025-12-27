package com.zen.entities.tenant;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "document_items")
@Where(clause = "document_type = 'SALES_ORDER'")
public class SalesOrderItem extends DocumentItemBase {

    @Column(name = "document_type", insertable = false, updatable = false)
    private String documentType = "SALES_ORDER";

    @Column(name = "document_id")
    private Long salesOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", insertable = false, updatable = false)
    private SalesOrder salesOrder;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "currency_code", length = 3)
    private String currencyCode = "USD";

    @PrePersist
    protected void onCreate() {
        this.documentType = "SALES_ORDER";
        if (salesOrder != null) {
            this.salesOrderId = salesOrder.getId();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.documentType = "SALES_ORDER";
        if (salesOrder != null) {
            this.salesOrderId = salesOrder.getId();
        }
    }

    // Getters and Setters
    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public Long getSalesOrderId() { return salesOrderId; }
    public void setSalesOrderId(Long salesOrderId) { 
        this.salesOrderId = salesOrderId;
    }

    public SalesOrder getSalesOrder() { return salesOrder; }
    public void setSalesOrder(SalesOrder salesOrder) { 
        this.salesOrder = salesOrder;
        if (salesOrder != null) {
            this.salesOrderId = salesOrder.getId();
        }
    }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }
    
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
