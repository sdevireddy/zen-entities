package com.zen.entities.tenant.enums;

public enum DiscountType {
    // Basic discount types
    NONE,
    PERCENTAGE,
    PERCENT,
    FLAT,
    FIXED,
    AMOUNT,
    
    // Volume-based discounts
    QUANTITY_BASED,
    TIERED,
    BULK,
    
    // Time-based discounts
    EARLY_BIRD,
    SEASONAL,
    LIMITED_TIME,
    
    // Customer-based discounts
    LOYALTY,
    VIP,
    FIRST_TIME_CUSTOMER,
    REFERRAL,
    
    // Product-based discounts
    BUNDLE,
    CROSS_SELL,
    UPSELL,
    CLEARANCE,
    
    // Advanced discount types
    BUY_ONE_GET_ONE,
    BOGO,
    FREE_SHIPPING,
    PROMOTIONAL,
    COUPON,
    VOUCHER
}