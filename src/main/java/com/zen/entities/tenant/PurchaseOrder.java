package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zen.entities.tenant.enums.PurchaseOrderStatus;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_orders")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "purchase_order_id")),
    @AttributeOverride(name = "documentNumber", column = @Column(name = "document_number")),
    @AttributeOverride(name = "expiryDate", column = @Column(name = "expiry_date")),
    @AttributeOverride(name = "ownerId", column = @Column(name = "owner_user_id")),
    @AttributeOverride(name = "status", column = @Column(name = "po_status", insertable = false, updatable = false))
})
public class PurchaseOrder extends DocumentBase {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    
    @Column(name = "currency_code", length = 3, nullable = false)
    private String currencyCode = "USD";
    
    @Enumerated(EnumType.STRING)
    @Column(name = "po_status", length = 50, nullable = false)
    private PurchaseOrderStatus poStatus = PurchaseOrderStatus.DRAFT;
    
    // Financial fields are inherited from DocumentBase with correct column names
    // No need to override them here
    
    // Using inherited status field from DocumentBase mapped to po_status column
    
    @Column(name = "promo_code")
    private String promoCode;
    
    @Column(name = "is_recurring")
    private Boolean isRecurring = false;
    
    @Column(name = "external_system_id", length = 100)
    private String externalSystemId;
    
    @Column(name = "related_invoice_id")
    private Long relatedInvoiceId;
    
    @Column(name = "related_sales_order_id")
    private Long relatedSalesOrderId;
    
    @Column(name = "rejected_reason", length = 1000)
    private String rejectedReason;
    
    // Analytics timestamps
    @Column(name = "order_placed_at")
    private Instant orderPlacedAt;
    
    @Column(name = "status_changed_at")
    private Instant statusChangedAt;
    
    @Column(name = "expected_delivery_time")
    private ZonedDateTime expectedDeliveryTime;
    
    @Column(name = "actual_delivery_time")
    private ZonedDateTime actualDeliveryTime;
    
    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> items = new ArrayList<>();

    // Getters and Setters
    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    
    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }
    
    public PurchaseOrderStatus getPoStatus() { return poStatus; }
    public void setPoStatus(PurchaseOrderStatus poStatus) { this.poStatus = poStatus; }
    
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    
    public BigDecimal getDiscountTotal() { return discountTotal; }
    public void setDiscountTotal(BigDecimal discountTotal) { this.discountTotal = discountTotal; }
    
    public BigDecimal getTaxTotal() { return taxTotal; }
    public void setTaxTotal(BigDecimal taxTotal) { this.taxTotal = taxTotal; }
    
    public BigDecimal getShippingCharges() { return shippingCharges; }
    public void setShippingCharges(BigDecimal shippingCharges) { this.shippingCharges = shippingCharges; }
    
    public BigDecimal getAdjustment() { return adjustment; }
    public void setAdjustment(BigDecimal adjustment) { this.adjustment = adjustment; }
    
    public BigDecimal getGrandTotal() { return grandTotal; }
    public void setGrandTotal(BigDecimal grandTotal) { this.grandTotal = grandTotal; }
    
    public List<PurchaseOrderItem> getItems() { return items; }
    public void setItems(List<PurchaseOrderItem> items) { this.items = items; }
    

    
    // Use inherited getStatus/setStatus methods from DocumentBase
    
    public String getPromoCode() { return promoCode; }
    public void setPromoCode(String promoCode) { this.promoCode = promoCode; }
    
    public Boolean getIsRecurring() { return isRecurring; }
    public void setIsRecurring(Boolean isRecurring) { this.isRecurring = isRecurring; }
    
    public String getExternalSystemId() { return externalSystemId; }
    public void setExternalSystemId(String externalSystemId) { this.externalSystemId = externalSystemId; }
    
    public Long getRelatedInvoiceId() { return relatedInvoiceId; }
    public void setRelatedInvoiceId(Long relatedInvoiceId) { this.relatedInvoiceId = relatedInvoiceId; }
    
    public Long getRelatedSalesOrderId() { return relatedSalesOrderId; }
    public void setRelatedSalesOrderId(Long relatedSalesOrderId) { this.relatedSalesOrderId = relatedSalesOrderId; }
    
    public String getRejectedReason() { return rejectedReason; }
    public void setRejectedReason(String rejectedReason) { this.rejectedReason = rejectedReason; }
    
    public Instant getOrderPlacedAt() { return orderPlacedAt; }
    public void setOrderPlacedAt(Instant orderPlacedAt) { this.orderPlacedAt = orderPlacedAt; }
    
    public Instant getStatusChangedAt() { return statusChangedAt; }
    public void setStatusChangedAt(Instant statusChangedAt) { this.statusChangedAt = statusChangedAt; }
    
    public ZonedDateTime getExpectedDeliveryTime() { return expectedDeliveryTime; }
    public void setExpectedDeliveryTime(ZonedDateTime expectedDeliveryTime) { this.expectedDeliveryTime = expectedDeliveryTime; }
    
    public ZonedDateTime getActualDeliveryTime() { return actualDeliveryTime; }
    public void setActualDeliveryTime(ZonedDateTime actualDeliveryTime) { this.actualDeliveryTime = actualDeliveryTime; }
    
    // Helper methods
    public String getOrderNumber() { return getDocumentNumber(); }
    public void setOrderNumber(String orderNumber) { setDocumentNumber(orderNumber); }
    
    public void addItem(PurchaseOrderItem item) {
        items.add(item);
        item.setPurchaseOrder(this);
    }
    
    public void removeItem(PurchaseOrderItem item) {
        items.remove(item);
        item.setPurchaseOrder(null);
    }
}