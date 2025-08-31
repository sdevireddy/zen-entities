package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lead_attachments")
public class LeadAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_id", nullable = false)
    private Lead lead;

    private String filename;
    private String contentType;
    private Long size;
    private String storageUrl;
    private String uploadedBy;
    private LocalDateTime uploadedAt;

    // No-args constructor
    public LeadAttachment() {}

    // All-args constructor
    public LeadAttachment(Long id, Lead lead, String filename, String contentType, Long size,
                          String storageUrl, String uploadedBy, LocalDateTime uploadedAt) {
        this.id = id;
        this.lead = lead;
        this.filename = filename;
        this.contentType = contentType;
        this.size = size;
        this.storageUrl = storageUrl;
        this.uploadedBy = uploadedBy;
        this.uploadedAt = uploadedAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Lead getLead() { return lead; }
    public void setLead(Lead lead) { this.lead = lead; }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }

    public Long getSize() { return size; }
    public void setSize(Long size) { this.size = size; }

    public String getStorageUrl() { return storageUrl; }
    public void setStorageUrl(String storageUrl) { this.storageUrl = storageUrl; }

    public String getUploadedBy() { return uploadedBy; }
    public void setUploadedBy(String uploadedBy) { this.uploadedBy = uploadedBy; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }

    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Lead lead;
        private String filename;
        private String contentType;
        private Long size;
        private String storageUrl;
        private String uploadedBy;
        private LocalDateTime uploadedAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder lead(Lead lead) {
            this.lead = lead;
            return this;
        }

        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }

        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder size(Long size) {
            this.size = size;
            return this;
        }

        public Builder storageUrl(String storageUrl) {
            this.storageUrl = storageUrl;
            return this;
        }

        public Builder uploadedBy(String uploadedBy) {
            this.uploadedBy = uploadedBy;
            return this;
        }

        public Builder uploadedAt(LocalDateTime uploadedAt) {
            this.uploadedAt = uploadedAt;
            return this;
        }

        public LeadAttachment build() {
            return new LeadAttachment(id, lead, filename, contentType, size, storageUrl, uploadedBy, uploadedAt);
        }
    }
}
