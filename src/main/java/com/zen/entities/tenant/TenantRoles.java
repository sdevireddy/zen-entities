package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant_roles")
public class TenantRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "is_default")
    private boolean isDefault;

    /** 🔹 Role -> Permission mapping */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tenant_role_module_permissions",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<TenantPermissions> permissions = new HashSet<>();

    /** 🔹 Role -> Feature Permission mapping */
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<TenantRoleFeaturePermission> featurePermissions = new HashSet<>();

    /** 🔹 Role -> Field Permission mapping */
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TenantFieldPermission> fieldPermissions = new HashSet<>();

    /** 🔹 Role -> Permission Bundle mapping */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tenant_role_bundle_assignments",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "bundle_id")
    )
    private Set<TenantPermissionBundle> permissionBundles = new HashSet<>();

    /** 🔹 Role -> Module mapping */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private TenantModule module;

    /** 🔹 New: Role <-> User bidirectional mapping */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<ZenUser> users = new HashSet<>();

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Set<TenantPermissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<TenantPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<TenantRoleFeaturePermission> getFeaturePermissions() {
        return featurePermissions;
    }

    public void setFeaturePermissions(Set<TenantRoleFeaturePermission> featurePermissions) {
        this.featurePermissions = featurePermissions;
    }

    public Set<TenantFieldPermission> getFieldPermissions() {
        return fieldPermissions;
    }

    public void setFieldPermissions(Set<TenantFieldPermission> fieldPermissions) {
        this.fieldPermissions = fieldPermissions;
    }

    public Set<TenantPermissionBundle> getPermissionBundles() {
        return permissionBundles;
    }

    public void setPermissionBundles(Set<TenantPermissionBundle> permissionBundles) {
        this.permissionBundles = permissionBundles;
    }

    public TenantModule getModule() {
        return module;
    }

    public void setModule(TenantModule module) {
        this.module = module;
    }

    public Set<ZenUser> getUsers() {
        return users;
    }

    public void setUsers(Set<ZenUser> users) {
        this.users = users;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
