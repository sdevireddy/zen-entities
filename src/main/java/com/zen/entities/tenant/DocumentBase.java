package com.zen.entities.tenant;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.zen.entities.tenant.enums.DocumentStatus;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DocumentBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name="document_number")
    protected String documentNumber;
    @Column(name="document_date")
    protected LocalDateTime documentDate;
    
    @Column(name = "title")
    protected String title;
    
    
    @Column(name = "valid_until")
    protected LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    protected DocumentStatus status;
    @Column(name = "subtotal_amount")
    protected BigDecimal subtotal;
    @Column(name = "discount_value")
    protected BigDecimal discountTotal;
    @Column(name = "tax_total_amount")
    protected BigDecimal taxTotal;
    @Column(name = "shipping_amount")
    protected BigDecimal shippingCharges;
    @Column(name = "adjustment_amount")
    protected BigDecimal adjustment;
    @Column(name = "grand_total_amount")
    protected BigDecimal grandTotal;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "document_id") // foreign key in Note table
    protected List<Note> notes;

    @Column(name= "owner_user_id")
    protected Long ownerId;
    @Column(name = "approved_by")
    protected Long approverId;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    protected LocalDateTime createdAt;
    
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    protected Long createdBy;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;
    
    @LastModifiedBy
    @Column(name = "updated_by")
    protected Long updatedBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public LocalDateTime getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(LocalDateTime documentDate) {
		this.documentDate = documentDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public DocumentStatus getStatus() {
		return status;
	}
	public void setStatus(DocumentStatus status) {
		this.status = status;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getDiscountTotal() {
		return discountTotal;
	}
	public void setDiscountTotal(BigDecimal discountTotal) {
		this.discountTotal = discountTotal;
	}
	public BigDecimal getTaxTotal() {
		return taxTotal;
	}
	public void setTaxTotal(BigDecimal taxTotal) {
		this.taxTotal = taxTotal;
	}
	public BigDecimal getShippingCharges() {
		return shippingCharges;
	}
	public void setShippingCharges(BigDecimal shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
	public BigDecimal getAdjustment() {
		return adjustment;
	}
	public void setAdjustment(BigDecimal adjustment) {
		this.adjustment = adjustment;
	}
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getApproverId() {
		return approverId;
	}
	public void setApproverId(Long approverId) {
		this.approverId = approverId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
