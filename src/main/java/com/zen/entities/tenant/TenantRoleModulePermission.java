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

@Entity
@Table(name = "tenant_role_module_permissions")

public class TenantRoleModulePermission {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private TenantRoles role;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private TenantModule module;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", nullable = true)
    private TenantFeature feature; // ✅ Optional

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private TenantPermissions permission;

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenantRoles getRole() {
        return role;
    }

    public void setRole(TenantRoles role) {
        this.role = role;
    }

    public TenantModule getModule() {
        return module;
    }

    public void setModule(TenantModule module) {
        this.module = module;
    }

    public TenantFeature getFeature() {
        return feature;
    }

    public void setFeature(TenantFeature feature) {
        this.feature = feature;
    }

    public TenantPermissions getPermission() {
        return permission;
    }

    public void setPermission(TenantPermissions permission) {
        this.permission = permission;
    }
}
