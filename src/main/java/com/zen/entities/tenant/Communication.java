package com.zen.entities.tenant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "communications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
        DRAFT, SENT, DELIVERED, READ, REPLIED, FAILED, BOUNCED
    }
}