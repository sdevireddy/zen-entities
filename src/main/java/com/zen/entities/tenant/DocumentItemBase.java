package com.zen.entities.tenant;

import java.math.BigDecimal;

import com.zen.entities.tenant.enums.DiscountType;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class DocumentItemBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@Column(name = "product_id", insertable = false, updatable = false)
	protected Long productId;

	@Column(name = "product_code", length = 100)
	protected String productCode;

	@Column(name = "product_name", nullable = false, length = 255)
	protected String productName;

	@Column(name = "description", length = 500)
	protected String description;

	@Column(name = "quantity", nullable = false)
	protected Integer quantity;

	@Column(name = "unit_price", precision = 18, scale = 2, nullable = false)
	protected BigDecimal unitPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "discount_type", length = 20)
	protected DiscountType discountType = DiscountType.NONE;

	@Column(name = "discount_value", precision = 18, scale = 2)
	protected BigDecimal discountValue = BigDecimal.ZERO;

	@Column(name = "tax_rate_pct", precision = 5, scale = 2)
	protected BigDecimal taxRatePct = BigDecimal.ZERO;

	@Column(name = "line_subtotal", precision = 18, scale = 2)
	protected BigDecimal lineSubtotal = BigDecimal.ZERO;

	@Column(name = "line_tax_total", precision = 18, scale = 2)
	protected BigDecimal lineTaxTotal = BigDecimal.ZERO;

	@Column(name = "line_total", precision = 18, scale = 2)
	protected BigDecimal lineTotal = BigDecimal.ZERO;

	@Column(name = "sort_order")
	protected Integer sortOrder = 1;

	// No-arg constructor
	public DocumentItemBase() {
	}

	// Full constructor
	public DocumentItemBase(Long id, String productCode, String productName, String description,
			Integer quantity, BigDecimal unitPrice, DiscountType discountType, BigDecimal discountValue,
			BigDecimal taxRatePct, BigDecimal lineSubtotal, BigDecimal lineTaxTotal, BigDecimal lineTotal,
			Integer sortOrder) {
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discountType = discountType != null ? discountType : DiscountType.NONE;
		this.discountValue = discountValue != null ? discountValue : BigDecimal.ZERO;
		this.taxRatePct = taxRatePct != null ? taxRatePct : BigDecimal.ZERO;
		this.lineSubtotal = lineSubtotal != null ? lineSubtotal : BigDecimal.ZERO;
		this.lineTaxTotal = lineTaxTotal != null ? lineTaxTotal : BigDecimal.ZERO;
		this.lineTotal = lineTotal != null ? lineTotal : BigDecimal.ZERO;
		this.sortOrder = sortOrder != null ? sortOrder : 1;
	}

	// DTO-style constructor
	public DocumentItemBase(Long id, String productName, String productCode, BigDecimal unitPrice, Integer quantity,
			BigDecimal lineTotal, String description) {
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.lineTotal = lineTotal;
		this.description = description;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}



	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public BigDecimal getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
	}

	public BigDecimal getTaxRatePct() {
		return taxRatePct;
	}

	public void setTaxRatePct(BigDecimal taxRatePct) {
		this.taxRatePct = taxRatePct;
	}

	public BigDecimal getLineSubtotal() {
		return lineSubtotal;
	}

	public void setLineSubtotal(BigDecimal lineSubtotal) {
		this.lineSubtotal = lineSubtotal;
	}

	public BigDecimal getLineTaxTotal() {
		return lineTaxTotal;
	}

	public void setLineTaxTotal(BigDecimal lineTaxTotal) {
		this.lineTaxTotal = lineTaxTotal;
	}

	public BigDecimal getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(BigDecimal lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	// Builder
	public static class Builder {
		private Long id;
		private String productCode;
		private String productName;
		private String description;
		private Integer quantity;
		private BigDecimal unitPrice;
		private DiscountType discountType;
		private BigDecimal discountValue;
		private BigDecimal taxRatePct;
		private BigDecimal lineSubtotal;
		private BigDecimal lineTaxTotal;
		private BigDecimal lineTotal;
		private Integer sortOrder;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder productCode(String productCode) {
			this.productCode = productCode;
			return this;
		}

		public Builder productName(String productName) {
			this.productName = productName;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder quantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder unitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
			return this;
		}



		public Builder discountType(DiscountType discountType) {
			this.discountType = discountType;
			return this;
		}

		public Builder discountValue(BigDecimal discountValue) {
			this.discountValue = discountValue;
			return this;
		}

		public Builder taxRatePct(BigDecimal taxRatePct) {
			this.taxRatePct = taxRatePct;
			return this;
		}

		public Builder lineSubtotal(BigDecimal lineSubtotal) {
			this.lineSubtotal = lineSubtotal;
			return this;
		}

		public Builder lineTaxTotal(BigDecimal lineTaxTotal) {
			this.lineTaxTotal = lineTaxTotal;
			return this;
		}

		public Builder lineTotal(BigDecimal lineTotal) {
			this.lineTotal = lineTotal;
			return this;
		}

		public Builder sortOrder(Integer sortOrder) {
			this.sortOrder = sortOrder;
			return this;
		}

		public DocumentItemBase build() {
			return new DocumentItemBase(id, productCode, productName, description, quantity, unitPrice,
					discountType, discountValue, taxRatePct, lineSubtotal, lineTaxTotal, lineTotal, sortOrder) {
			};
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
