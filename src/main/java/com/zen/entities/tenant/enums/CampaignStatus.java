package com.zen.entities.tenant.enums;

public enum CampaignStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    PAUSED("Paused"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");
    
    private final String displayName;
    
    CampaignStatus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}