package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "quote_items")
public class QuoteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id")
    private Quote quote;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "discount_value", precision = 10, scale = 2)
    private BigDecimal discountValue;

    @Column(name = "tax_rate_pct", precision = 5, scale = 2)
    private BigDecimal taxRatePct;

    @Column(name = "line_subtotal", precision = 10, scale = 2)
    private BigDecimal lineSubtotal;

    @Column(name = "line_tax_total", precision = 10, scale = 2)
    private BigDecimal lineTaxTotal;

    @Column(name = "line_total", precision = 10, scale = 2)
    private BigDecimal lineTotal;

    @Column(name = "sort_order")
    private Integer sortOrder;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Quote getQuote() { return quote; }
    public void setQuote(Quote quote) { this.quote = quote; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    public String getDiscountType() { return discountType; }
    public void setDiscountType(String discountType) { this.discountType = discountType; }

    public BigDecimal getDiscountValue() { return discountValue; }
    public void setDiscountValue(BigDecimal discountValue) { this.discountValue = discountValue; }

    public BigDecimal getTaxRatePct() { return taxRatePct; }
    public void setTaxRatePct(BigDecimal taxRatePct) { this.taxRatePct = taxRatePct; }

    public BigDecimal getLineSubtotal() { return lineSubtotal; }
    public void setLineSubtotal(BigDecimal lineSubtotal) { this.lineSubtotal = lineSubtotal; }

    public BigDecimal getLineTaxTotal() { return lineTaxTotal; }
    public void setLineTaxTotal(BigDecimal lineTaxTotal) { this.lineTaxTotal = lineTaxTotal; }

    public BigDecimal getLineTotal() { return lineTotal; }
    public void setLineTotal(BigDecimal lineTotal) { this.lineTotal = lineTotal; }

    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
}