package com.zen.entities.tenant;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tenant_role_feature_permissions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"role_id", "feature_id", "permission_id"})
})

public class TenantRoleFeaturePermission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private TenantRoles role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id")
    private TenantFeature feature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private TenantPermissions permission;

    public Long getId() { return id; }

    public TenantRoles getRole() { return role; }
    public void setRole(TenantRoles role) { this.role = role; }

    public TenantFeature getFeature() { return feature; }
    public void setFeature(TenantFeature feature) { this.feature = feature; }

    public TenantPermissions getPermission() { return permission; }
    public void setPermission(TenantPermissions permission) { this.permission = permission; }
}

