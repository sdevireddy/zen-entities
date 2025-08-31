package com.zen.entities.tenant;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant_permissions")
public class TenantPermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String description;

    /** 🔹 Reverse mapping for Many-to-Many */
    @ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY)
    private Set<TenantRoles> roles = new HashSet<>();

    // --- Getters & Setters ---
    
 // TenantPermissions.java
    public TenantPermissions(String name) {
        this.name = name;
    }
    
    public TenantPermissions() {
	}

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TenantRoles> getRoles() {
        return roles;
    }

    public void setRoles(Set<TenantRoles> roles) {
        this.roles = roles;
    }
}
