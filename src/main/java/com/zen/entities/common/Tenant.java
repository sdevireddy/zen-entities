package com.zen.entities.common;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tenants",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"tenant_org_name", "suffix"}),
           @UniqueConstraint(columnNames = {"schema_name"})
       })
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // internal auto-increment ID

    @Column(name = "org_name", nullable = false)
    private String orgName;  // Display name

    @Column(name = "tenant_org_name", nullable = false)
    private String tenantOrgName;  // sanitized org key (prefix)

    @Column(name = "suffix", nullable = false, length = 8)
    private String suffix; // 8-digit unique suffix

    @Column(name = "schema_name", nullable = false, unique = true)
    private String schemaName; // tenant schema: prefix_suffix

    @Column(name = "admin_username", nullable = false)
    private String adminUsername;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "tenant_status")
    private String tenantStatus;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "created_by_ip")
    private String createdByIp;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getTenantOrgName() {
		return tenantOrgName;
	}

	public void setTenantOrgName(String tenantOrgName) {
		this.tenantOrgName = tenantOrgName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTenantStatus() {
		return tenantStatus;
	}

	public void setTenantStatus(String tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getCreatedByIp() {
		return createdByIp;
	}

	public void setCreatedByIp(String createdByIp) {
		this.createdByIp = createdByIp;
	}

}
