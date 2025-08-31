package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temporary_permissions")
public class TemporaryPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private ZenUser user;

    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    private TenantFeature feature;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private TenantPermissions permission;

    @Column(name = "granted_at")
    private LocalDateTime grantedAt = LocalDateTime.now();

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "granted_by")
    private Long grantedBy;

    @Column(name = "reason")
    private String reason;

    @Column(name = "is_active")
    private Boolean isActive = true;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ZenUser getUser() { return user; }
    public void setUser(ZenUser user) { this.user = user; }

    public TenantFeature getFeature() { return feature; }
    public void setFeature(TenantFeature feature) { this.feature = feature; }

    public TenantPermissions getPermission() { return permission; }
    public void setPermission(TenantPermissions permission) { this.permission = permission; }

    public LocalDateTime getGrantedAt() { return grantedAt; }
    public void setGrantedAt(LocalDateTime grantedAt) { this.grantedAt = grantedAt; }

    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }

    public Long getGrantedBy() { return grantedBy; }
    public void setGrantedBy(Long grantedBy) { this.grantedBy = grantedBy; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
