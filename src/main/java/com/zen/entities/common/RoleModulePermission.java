package com.zen.entities.common;

import jakarta.persistence.*;
import com.zen.entities.common.CommonModule;

@Entity
@Table(name = "role_module_permissions")
public class RoleModulePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Roles role;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private CommonModule module;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", nullable = true)
    private Feature feature; // ✅ Optional

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private Permissions permission;

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public CommonModule getModule() {
        return module;
    }

    public void setModule(CommonModule module) {
        this.module = module;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Permissions getPermission() {
        return permission;
    }

    public void setPermission(Permissions permission) {
        this.permission = permission;
    }
}
