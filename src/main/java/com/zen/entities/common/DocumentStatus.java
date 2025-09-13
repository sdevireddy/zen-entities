package com.zen.entities.common;

/**
 * Generic document status enum for all document types (Quote, Invoice, Order, etc.)
 * Provides standard lifecycle states that apply to most business documents
 */
public enum DocumentStatus {
    
    // Initial States
    DRAFT("Draft - Document is being created/edited"),
    PENDING_REVIEW("Pending Review - Awaiting internal review"),
    
    // Approval States  
    PENDING_APPROVAL("Pending Approval - Awaiting approval"),
    APPROVED("Approved - Document has been approved"),
    REJECTED("Rejected - Document was rejected"),
    
    // Active States
    ACTIVE("Active - Document is active and valid"),
    SENT("Sent - Document has been sent to recipient"),
    RECEIVED("Received - Document has been received"),
    
    // Completion States
    ACCEPTED("Accepted - Document has been accepted"),
    COMPLETED("Completed - Document processing is complete"),
    CLOSED("Closed - Document is closed"),
    
    // Cancellation States
    CANCELLED("Cancelled - Document has been cancelled"),
    EXPIRED("Expired - Document has expired"),
    VOID("Void - Document has been voided"),
    
    // Special States
    ON_HOLD("On Hold - Document is temporarily on hold"),
    ARCHIVED("Archived - Document has been archived");
    
    private final String description;
    
    DocumentStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    // Helper methods for common status checks
    public boolean isDraft() {
        return this == DRAFT;
    }
    
    public boolean isPending() {
        return this == PENDING_REVIEW || this == PENDING_APPROVAL;
    }
    
    public boolean isApproved() {
        return this == APPROVED;
    }
    
    public boolean isActive() {
        return this == ACTIVE || this == SENT || this == RECEIVED;
    }
    
    public boolean isCompleted() {
        return this == COMPLETED || this == CLOSED || this == ACCEPTED;
    }
    
    public boolean isCancelled() {
        return this == CANCELLED || this == EXPIRED || this == VOID;
    }
    
    public boolean isFinal() {
        return isCompleted() || isCancelled() || this == ARCHIVED;
    }
}