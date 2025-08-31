package com.zen.entities.tenant;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_items")
@AttributeOverride(name = "id", column = @Column(name = "invoice_item_id"))
public class InvoiceItem extends DocumentItemBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and Setters
    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}