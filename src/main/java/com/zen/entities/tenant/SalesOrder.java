package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.zen.entities.tenant.enums.SalesOrderStatus;

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
@Table(name = "sales_orders")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "sales_order_id")),
    @AttributeOverride(name = "documentNumber", column = @Column(name = "order_number")),
    @AttributeOverride(name = "ownerId", column = @Column(name = "owner_user_id"))
})
public class SalesOrder extends DocumentBase {

    // orderNumber is inherited from DocumentBase as documentNumber

    @Column(name = "currency_code", length = 3, nullable = false)
    private String currencyCode = "USD";

    @Enumerated(EnumType.STRING)
    @Column(name = "so_status", length = 50, nullable = false)
    private SalesOrderStatus soStatus = SalesOrderStatus.DRAFT;

    // ---- Financial totals (analytics ready) ----
    @Column(name = "subtotal", precision = 15, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "discount_total", precision = 15, scale = 2)
    private BigDecimal discountTotal;

    @Column(name = "tax_total", precision = 15, scale = 2)
    private BigDecimal taxTotal;

    @Column(name = "shipping_charges", precision = 15, scale = 2)
    private BigDecimal shippingCharges;

    @Column(name = "adjustment", precision = 15, scale = 2)
    private BigDecimal adjustment;

    @Column(name = "grand_total", precision = 15, scale = 2)
    private BigDecimal grandTotal;

    // ---- CRM / External Links ----
    @Column(name = "customer_id")
    private Long customerId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Account customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
    
    @Column(name = "promo_code")
    private String promoCode;
    
    @Column(name = "is_recurring")
    private Boolean isRecurring = false;

    @Column(name = "external_system_id", length = 100)
    private String externalSystemId;

    @Column(name = "related_invoice_id")
    private Long relatedInvoiceId;

    @Column(name = "related_po_id")
    private Long relatedPurchaseOrderId;

    // ---- Associations ----
    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<SalesOrderItem> items = new ArrayList<>();

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SalesOrderTax> taxes = new ArrayList<>();

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SalesOrderShipment> shipments = new ArrayList<>();

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SalesOrderStatusHistory> statusHistory = new ArrayList<>();

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Attachment> attachments = new ArrayList<>();
    
    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SalesOrderApproval> approvals = new ArrayList<>();
    
    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SalesOrderNotification> notifications = new ArrayList<>();


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

    // ---- Helper methods ----
    public void addItem(SalesOrderItem item) {
        items.add(item);
        item.setSalesOrder(this);
    }

    public void removeItem(SalesOrderItem item) {
        items.remove(item);
        item.setSalesOrder(null);
    }

    public void addTax(SalesOrderTax tax) {
        taxes.add(tax);
        tax.setSalesOrder(this);
    }

    public void removeTax(SalesOrderTax tax) {
        taxes.remove(tax);
        tax.setSalesOrder(null);
    }

    public void addShipment(SalesOrderShipment sh) {
        shipments.add(sh);
        sh.setSalesOrder(this);
    }

    public void removeShipment(SalesOrderShipment sh) {
        shipments.remove(sh);
        sh.setSalesOrder(null);
    }

    public void addStatusHistory(SalesOrderStatusHistory h) {
        statusHistory.add(h);
        h.setSalesOrder(this);
    }

    public void addPayment(Payment p) {
        payments.add(p);
        p.setSalesOrder(this);
    }

    public void addAttachment(Attachment a) {
        attachments.add(a);
        a.setSalesOrder(this);
    }

    // ---- Getters & Setters ----
    public String getOrderNumber() { return getDocumentNumber(); }
    public void setOrderNumber(String orderNumber) { setDocumentNumber(orderNumber); }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public SalesOrderStatus getSoStatus() { return soStatus; }
    public void setSoStatus(SalesOrderStatus soStatus) { this.soStatus = soStatus; }

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

    public Account getCustomer() { return customer; }
    public void setCustomer(Account customer) { this.customer = customer; }
    
    public Address getBillingAddress() { return billingAddress; }
    public void setBillingAddress(Address billingAddress) { this.billingAddress = billingAddress; }
    
    public Address getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(Address shippingAddress) { this.shippingAddress = shippingAddress; }
    
    public String getPromoCode() { return promoCode; }
    public void setPromoCode(String promoCode) { this.promoCode = promoCode; }
    
    public Boolean getIsRecurring() { return isRecurring; }
    public void setIsRecurring(Boolean isRecurring) { this.isRecurring = isRecurring; }
    
    public List<SalesOrderApproval> getApprovals() { return approvals; }
    public void setApprovals(List<SalesOrderApproval> approvals) { this.approvals = approvals; }
    
    public List<SalesOrderNotification> getNotifications() { return notifications; }
    public void setNotifications(List<SalesOrderNotification> notifications) { this.notifications = notifications; }

    public String getExternalSystemId() { return externalSystemId; }
    public void setExternalSystemId(String externalSystemId) { this.externalSystemId = externalSystemId; }

    // Industry-standard accountId methods
    public Long getAccountId() {
        return customerId;
    }
    
    public Long getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    
    public void setAccountId(Long accountId) {
        if (accountId != null) {
            Account account = new Account();
            account.setId(accountId);
            this.customer = account;
        } else {
            this.customer = null;
        }
    }

    public Long getRelatedInvoiceId() { return relatedInvoiceId; }
    public void setRelatedInvoiceId(Long relatedInvoiceId) { this.relatedInvoiceId = relatedInvoiceId; }

    public Long getRelatedPurchaseOrderId() { return relatedPurchaseOrderId; }
    public void setRelatedPurchaseOrderId(Long relatedPurchaseOrderId) { this.relatedPurchaseOrderId = relatedPurchaseOrderId; }

    public List<SalesOrderItem> getItems() { return items; }
    public void setItems(List<SalesOrderItem> items) { this.items = items; }

    public List<SalesOrderTax> getTaxes() { return taxes; }
    public void setTaxes(List<SalesOrderTax> taxes) { this.taxes = taxes; }

    public List<SalesOrderShipment> getShipments() { return shipments; }
    public void setShipments(List<SalesOrderShipment> shipments) { this.shipments = shipments; }

    public List<SalesOrderStatusHistory> getStatusHistory() { return statusHistory; }
    public void setStatusHistory(List<SalesOrderStatusHistory> statusHistory) { this.statusHistory = statusHistory; }

    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }

    public List<Attachment> getAttachments() { return attachments; }
    public void setAttachments(List<Attachment> attachments) { this.attachments = attachments; }

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
}
