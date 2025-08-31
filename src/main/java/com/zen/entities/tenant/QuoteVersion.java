package com.zen.entities.tenant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "quote_versions")
public class QuoteVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Long versionId;

    @ManyToOne
    @JoinColumn(name = "quote_id")
    private Quote quote;

    @Column(name = "version_number")
    private Integer versionNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "notes")
    private String notes;

    // Getters and Setters
    public Long getVersionId() {
        return versionId;
    }
    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }
    public Quote getQuote() {
        return quote;
    }
    public void setQuote(Quote quote) {
        this.quote = quote;
    }
    public Integer getVersionNumber() {
        return versionNumber;
    }
    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Long getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
