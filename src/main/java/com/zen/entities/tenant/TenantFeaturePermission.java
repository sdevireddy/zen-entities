package com.zen.entities.tenant;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant_feature_permissions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"feature_id", "permission_id"})
})
public class TenantFeaturePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id")
    private TenantFeature feature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private TenantPermissions permission;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TenantFeature getFeature() { return feature; }
    public void setFeature(TenantFeature feature) { this.feature = feature; }

    public TenantPermissions getPermission() { return permission; }
    public void setPermission(TenantPermissions permission) { this.permission = permission; }
}