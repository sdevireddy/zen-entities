package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "quote_items")
@AttributeOverride(name = "id", column = @Column(name = "item_id"))
public class QuoteItem extends DocumentItemBase {

	@ManyToOne
	@JoinColumn(name = "quote_id")
	private Quote quote;

	private BigDecimal discountValue;
	private BigDecimal taxRatePct;
	private Integer sortOrder;

	// No-arg constructor
	public QuoteItem() {
	}

	// All-args constructor
	public QuoteItem(Long itemId, String productName, String productCode, BigDecimal unitPrice, Integer quantity,
			BigDecimal total, String description, Quote quote, BigDecimal discountValue, BigDecimal taxRatePct,
			Integer sortOrder) {
		super(itemId, productName, productCode, unitPrice, quantity, total, description);
		this.quote = quote;
		this.discountValue = discountValue;
		this.taxRatePct = taxRatePct;
		this.sortOrder = sortOrder;
	}

	// Getters and Setters
	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
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

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	// Builder
	public static class Builder {
		private Long itemId;
		private String productName;
		private String productCode;
		private BigDecimal unitPrice;
		private Integer quantity;
		private BigDecimal total;
		private String description;
		private Quote quote;
		private BigDecimal discountValue;
		private BigDecimal taxRatePct;
		private Integer sortOrder;

		public Builder itemId(Long itemId) {
			this.itemId = itemId;
			return this;
		}

		public Builder productName(String productName) {
			this.productName = productName;
			return this;
		}

		public Builder productCode(String productCode) {
			this.productCode = productCode;
			return this;
		}

		public Builder unitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
			return this;
		}

		public Builder quantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder total(BigDecimal total) {
			this.total = total;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder quote(Quote quote) {
			this.quote = quote;
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

		public Builder sortOrder(Integer sortOrder) {
			this.sortOrder = sortOrder;
			return this;
		}

		public QuoteItem build() {
			return new QuoteItem(itemId, productName, productCode, unitPrice, quantity, total, description, quote,
					discountValue, taxRatePct, sortOrder);
		}

		public static Builder builder() {
			return new Builder();
		}
	}
}
