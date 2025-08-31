package com.zen.entities.tenant;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "entity_tags")
public class EntityTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    private String entityType; // LEAD, CONTACT, DEAL, ACCOUNT, QUOTE, SALES_ORDER, PURCHASE_ORDER, INVOICE, PRODUCT, CAMPAIGN, TASK, EVENT, CALL, EMAIL, NOTE, DOCUMENT
    private Long entityId;
    private String taggedBy;
    private LocalDateTime taggedAt;

    public EntityTag() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Tag getTag() { return tag; }
    public void setTag(Tag tag) { this.tag = tag; }

    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public String getTaggedBy() { return taggedBy; }
    public void setTaggedBy(String taggedBy) { this.taggedBy = taggedBy; }

    public LocalDateTime getTaggedAt() { return taggedAt; }
    public void setTaggedAt(LocalDateTime taggedAt) { this.taggedAt = taggedAt; }
}