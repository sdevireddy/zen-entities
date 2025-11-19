package com.zen.entities.common;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String description;
    
    private String featureCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private CommonModule module;

    @OneToMany(mappedBy = "feature", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RoleFeaturePermission> roleFeaturePermissions = new HashSet<>();

    public Feature() {}

    public Feature(String name, CommonModule module) {
        this.name = name;
        this.module = module;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonModule getModule() {
        return module;
    }

    public void setModule(CommonModule module) {
        this.module = module;
    }

    public Set<RoleFeaturePermission> getRoleFeaturePermissions() {
        return roleFeaturePermissions;
    }

    public void setRoleFeaturePermissions(Set<RoleFeaturePermission> roleFeaturePermissions) {
        this.roleFeaturePermissions = roleFeaturePermissions;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFeatureCategory() {
		return featureCategory;
	}
	
	public void setFeatureCategory(String featureCategory) {
		this.featureCategory = featureCategory;
	}
    
}
