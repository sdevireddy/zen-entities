package com.zen.entities.tenant;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name = "communications")
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false)
    private EntityType entityType;

    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "communication_type", nullable = false)
    private CommunicationType communicationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "direction", nullable = false)
    private Direction direction;

    @Column(name = "subject", length = 1000)
    private String subject;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "from_address", length = 512)
    private String fromAddress;

    @Column(name = "to_address", length = 512)
    private String toAddress;

    @Column(name = "cc_addresses", columnDefinition = "TEXT")
    private String ccAddresses;

    @Column(name = "bcc_addresses", columnDefinition = "TEXT")
    private String bccAddresses;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CommunicationStatus status = CommunicationStatus.SENT;

    @Column(name = "platform", length = 50)
    private String platform;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "thread_id")
    private String threadId;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "attachments", columnDefinition = "JSON")
    private String attachments;

    @Column(name = "metadata", columnDefinition = "JSON")
    private String metadata;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    @Column(name = "replied_at")
    private LocalDateTime repliedAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Retry mechanism fields
    @Column(name = "retry_count", nullable = false)
    private Integer retryCount = 0;

    @Column(name = "next_retry_at")
    private LocalDateTime nextRetryAt;

    @Column(name = "last_retry_at")
    private LocalDateTime lastRetryAt;

    @Column(name = "failure_reason", length = 1000)
    private String failureReason;

    // Constructors
    public Communication() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public EntityType getEntityType() { return entityType; }
    public void setEntityType(EntityType entityType) { this.entityType = entityType; }

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public CommunicationType getCommunicationType() { return communicationType; }
    public void setCommunicationType(CommunicationType communicationType) { this.communicationType = communicationType; }

    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getFromAddress() { return fromAddress; }
    public void setFromAddress(String fromAddress) { this.fromAddress = fromAddress; }

    public String getToAddress() { return toAddress; }
    public void setToAddress(String toAddress) { this.toAddress = toAddress; }

    public String getCcAddresses() { return ccAddresses; }
    public void setCcAddresses(String ccAddresses) { this.ccAddresses = ccAddresses; }

    public String getBccAddresses() { return bccAddresses; }
    public void setBccAddresses(String bccAddresses) { this.bccAddresses = bccAddresses; }

    public CommunicationStatus getStatus() { return status; }
    public void setStatus(CommunicationStatus status) { this.status = status; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public String getThreadId() { return threadId; }
    public void setThreadId(String threadId) { this.threadId = threadId; }

    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    public String getAttachments() { return attachments; }
    public void setAttachments(String attachments) { this.attachments = attachments; }

    public String getMetadata() { return metadata; }
    public void setMetadata(String metadata) { this.metadata = metadata; }

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }

    public LocalDateTime getDeliveredAt() { return deliveredAt; }
    public void setDeliveredAt(LocalDateTime deliveredAt) { this.deliveredAt = deliveredAt; }

    public LocalDateTime getReadAt() { return readAt; }
    public void setReadAt(LocalDateTime readAt) { this.readAt = readAt; }

    public LocalDateTime getRepliedAt() { return repliedAt; }
    public void setRepliedAt(LocalDateTime repliedAt) { this.repliedAt = repliedAt; }

    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // Retry mechanism getters and setters
    public Integer getRetryCount() { return retryCount; }
    public void setRetryCount(Integer retryCount) { this.retryCount = retryCount; }

    public LocalDateTime getNextRetryAt() { return nextRetryAt; }
    public void setNextRetryAt(LocalDateTime nextRetryAt) { this.nextRetryAt = nextRetryAt; }

    public LocalDateTime getLastRetryAt() { return lastRetryAt; }
    public void setLastRetryAt(LocalDateTime lastRetryAt) { this.lastRetryAt = lastRetryAt; }

    public String getFailureReason() { return failureReason; }
    public void setFailureReason(String failureReason) { this.failureReason = failureReason; }

    // Legacy method aliases for backward compatibility
    public String getType() { return communicationType != null ? communicationType.toString() : null; }
    public void setType(String type) { 
        if (type != null) {
            this.communicationType = CommunicationType.valueOf(type.toUpperCase());
        }
    }

    public String getToRecipients() { return toAddress; }
    public void setToRecipients(String toRecipients) { this.toAddress = toRecipients; }

    public String getFromEmail() { return fromAddress; }
    public void setFromEmail(String fromEmail) { this.fromAddress = fromEmail; }

    public Long getSentByUserId() { return createdBy; }
    public void setSentByUserId(Long sentByUserId) { this.createdBy = sentByUserId; }

    // JPA lifecycle methods
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Enums
    public enum EntityType {
        LEAD, CONTACT, ACCOUNT, DEAL
    }

    public enum CommunicationType {
        EMAIL, SMS, WHATSAPP, FACEBOOK, INSTAGRAM, TWITTER, LINKEDIN, TELEGRAM, CALL, MEETING
    }

    public enum Direction {
        INBOUND, OUTBOUND
    }

    public enum CommunicationStatus {
        DRAFT, SENDING, SENT, DELIVERED, READ, REPLIED, FAILED, BOUNCED, RETRY_SCHEDULED, FAILED_PERMANENTLY
    }
}