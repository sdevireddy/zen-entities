package com.zen.entities.tenant;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_order_items")
@AttributeOverride(name = "id", column = @Column(name = "purchase_order_item_id"))
public class PurchaseOrderItem extends DocumentItemBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and Setters
    public PurchaseOrder getPurchaseOrder() { return purchaseOrder; }
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) { this.purchaseOrder = purchaseOrder; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}