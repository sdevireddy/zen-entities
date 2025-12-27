package com.zen.entities.common;

import java.time.Instant;
import jakarta.persistence.*;

@Entity
@Table(name = "tenants",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"tenant_org_name"}),
           @UniqueConstraint(columnNames = {"tenant_org_name", "suffix"}),
           @UniqueConstraint(columnNames = {"schema_name"})
       })
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_name", nullable = false)
    private String orgName;

    @Column(name = "tenant_org_name", nullable = false)
    private String tenantOrgName;

    @Column(name = "suffix", nullable = false, length = 8)
    private String suffix;

    @Column(name = "schema_name", nullable = false, unique = true)
    private String schemaName;

    @Column(name = "admin_username", nullable = false)
    private String adminUsername;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "email_verified", nullable = false)
    private Boolean emailVerified = false;

    @Column(name = "verification_token")
    private String verificationToken;

    @Column(name = "email_verification_token_expires_at")
    private Instant emailVerificationTokenExpiresAt;

    @Column(name = "verification_attempts")
    private Integer verificationAttempts = 0;

    @Column(name = "verified_at")
    private Instant verifiedAt;

    @Column(name = "last_verification_attempt")
    private Instant lastVerificationAttempt;

    @Column(name = "status", length = 50)
    private String status = "PENDING_VERIFICATION";

    @Column(name = "created_by_ip", length = 50)
    private String createdByIp;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    // Constructors
    public Tenant() {}

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now(); // UTC time
        updatedAt = Instant.now(); // UTC time
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now(); // UTC time
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }

    public String getTenantOrgName() { return tenantOrgName; }
    public void setTenantOrgName(String tenantOrgName) { this.tenantOrgName = tenantOrgName; }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix; }

    public String getSchemaName() { return schemaName; }
    public void setSchemaName(String schemaName) { this.schemaName = schemaName; }

    public String getAdminUsername() { return adminUsername; }
    public void setAdminUsername(String adminUsername) { this.adminUsername = adminUsername; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getEmailVerified() { return emailVerified; }
    public void setEmailVerified(Boolean emailVerified) { this.emailVerified = emailVerified; }

    public String getVerificationToken() { return verificationToken; }
    public void setVerificationToken(String verificationToken) { this.verificationToken = verificationToken; }

    public Instant getEmailVerificationTokenExpiresAt() { return emailVerificationTokenExpiresAt; }
    public void setEmailVerificationTokenExpiresAt(Instant emailVerificationTokenExpiresAt) { 
        this.emailVerificationTokenExpiresAt = emailVerificationTokenExpiresAt; 
    }

    public Integer getVerificationAttempts() { return verificationAttempts; }
    public void setVerificationAttempts(Integer verificationAttempts) { this.verificationAttempts = verificationAttempts; }

    public Instant getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(Instant verifiedAt) { this.verifiedAt = verifiedAt; }

    public Instant getLastVerificationAttempt() { return lastVerificationAttempt; }
    public void setLastVerificationAttempt(Instant lastVerificationAttempt) { 
        this.lastVerificationAttempt = lastVerificationAttempt; 
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedByIp() { return createdByIp; }
    public void setCreatedByIp(String createdByIp) { this.createdByIp = createdByIp; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
