package com.zen.entities.tenant;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "document_items")
@Where(clause = "document_type = 'PURCHASE_ORDER'")
public class PurchaseOrderItem extends DocumentItemBase {

    @Column(name = "document_type", insertable = false, updatable = false)
    private String documentType = "PURCHASE_ORDER";

    @Column(name = "document_id")
    private Long purchaseOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", insertable = false, updatable = false)
    private PurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @PrePersist
    protected void onCreate() {
        this.documentType = "PURCHASE_ORDER";
        if (purchaseOrder != null) {
            this.purchaseOrderId = purchaseOrder.getId();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.documentType = "PURCHASE_ORDER";
        if (purchaseOrder != null) {
            this.purchaseOrderId = purchaseOrder.getId();
        }
    }

    // Getters and Setters
    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public Long getPurchaseOrderId() { return purchaseOrderId; }
    public void setPurchaseOrderId(Long purchaseOrderId) { 
        this.purchaseOrderId = purchaseOrderId;
    }

    public PurchaseOrder getPurchaseOrder() { return purchaseOrder; }
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) { 
        this.purchaseOrder = purchaseOrder;
        if (purchaseOrder != null) {
            this.purchaseOrderId = purchaseOrder.getId();
        }
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}