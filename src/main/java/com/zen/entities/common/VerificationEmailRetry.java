package com.zen.entities.common;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity for storing verification email retry information in common schema
 * Used for tenant email verification retries before tenant schema exists
 */
@Entity
@Table(name = "verification_email_retries")
public class VerificationEmailRetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id")
    private Long tenantId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "subject", nullable = false, length = 500)
    private String subject;

    @Column(name = "template_type", nullable = false, length = 100)
    private String templateType = "TENANT_EMAIL_VERIFICATION";

    @Column(name = "variables", columnDefinition = "JSON")
    private String variables;

    // Retry tracking
    @Column(name = "retry_count", nullable = false)
    private Integer retryCount = 0;

    @Column(name = "max_retries", nullable = false)
    private Integer maxRetries = 3;

    @Column(name = "next_retry_at")
    private LocalDateTime nextRetryAt;

    @Column(name = "last_retry_at")
    private LocalDateTime lastRetryAt;

    // Status tracking
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RetryStatus status = RetryStatus.PENDING;

    @Column(name = "failure_reason", columnDefinition = "TEXT")
    private String failureReason;

    // Timestamps
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Constructors
    public VerificationEmailRetry() {
        // Use UTC time consistently across all instances
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public VerificationEmailRetry(String email, String subject, String templateType, String variables) {
        this();
        this.email = email;
        this.subject = subject;
        this.templateType = templateType;
        this.variables = variables;
        // Use UTC time consistently
        this.nextRetryAt = LocalDateTime.now().plusMinutes(5); // First retry in 5 minutes
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTenantId() { return tenantId; }
    public void setTenantId(Long tenantId) { this.tenantId = tenantId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getTemplateType() { return templateType; }
    public void setTemplateType(String templateType) { this.templateType = templateType; }

    public String getVariables() { return variables; }
    public void setVariables(String variables) { this.variables = variables; }

    public Integer getRetryCount() { return retryCount; }
    public void setRetryCount(Integer retryCount) { this.retryCount = retryCount; }

    public Integer getMaxRetries() { return maxRetries; }
    public void setMaxRetries(Integer maxRetries) { this.maxRetries = maxRetries; }

    public LocalDateTime getNextRetryAt() { return nextRetryAt; }
    public void setNextRetryAt(LocalDateTime nextRetryAt) { this.nextRetryAt = nextRetryAt; }

    public LocalDateTime getLastRetryAt() { return lastRetryAt; }
    public void setLastRetryAt(LocalDateTime lastRetryAt) { this.lastRetryAt = lastRetryAt; }

    public RetryStatus getStatus() { return status; }
    public void setStatus(RetryStatus status) { this.status = status; }

    public String getFailureReason() { return failureReason; }
    public void setFailureReason(String failureReason) { this.failureReason = failureReason; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // Helper methods - DEPRECATED: Use markAsFailed instead
    @Deprecated
    public void incrementRetryCount() {
        this.retryCount++;
        this.lastRetryAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        
        if (this.retryCount >= this.maxRetries) {
            this.status = RetryStatus.FAILED_PERMANENTLY;
            this.nextRetryAt = null;
        } else {
            // Exponential backoff: 5min, 15min, 45min
            int delayMinutes = 5 * (int) Math.pow(3, this.retryCount - 1);
            this.nextRetryAt = LocalDateTime.now().plusMinutes(delayMinutes);
            this.status = RetryStatus.RETRYING;
        }
    }

    public void markAsSent() {
        this.status = RetryStatus.SENT;
        this.nextRetryAt = null;
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsFailed(String reason) {
        this.failureReason = reason;
        LocalDateTime now = LocalDateTime.now(); // Use consistent time
        this.updatedAt = now;
        this.lastRetryAt = now;
        this.retryCount++;
        
        if (this.retryCount >= this.maxRetries) {
            this.status = RetryStatus.FAILED_PERMANENTLY;
            this.nextRetryAt = null;
        } else {
            // Set next retry time but the new logic will ignore it
            int delayMinutes = 5 * (int) Math.pow(3, this.retryCount - 1);
            this.nextRetryAt = now.plusMinutes(delayMinutes);
            this.status = RetryStatus.RETRYING;
        }
    }

    // JPA lifecycle methods
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        if (createdAt == null) {
            createdAt = now;
        }
        if (updatedAt == null) {
            updatedAt = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Enums
    public enum RetryStatus {
        PENDING, RETRYING, SENT, FAILED_PERMANENTLY
    }
}