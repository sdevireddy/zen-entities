package com.zen.entities.tenant.enums;

public enum ShipmentStatus {
    PENDING("Pending"),
    SHIPPED("Shipped"),
    IN_TRANSIT("In Transit"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled"),
    RETURNED("Returned");
    
    private final String displayName;
    
    ShipmentStatus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}