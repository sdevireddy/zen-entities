package com.zen.entities.tenant;

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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "tenant_features")
public class TenantFeature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private boolean enabled = true;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	private TenantModule module;

	@OneToMany(mappedBy = "feature", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<TenantRoleFeaturePermission> roleFeaturePermissions = new HashSet<>();

	public TenantFeature() {
	}
	
	public TenantFeature(String name) {
	    this.name = name;
	}

	public TenantFeature(String name, TenantModule module) {
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

	public TenantModule getModule() {
		return module;
	}

	public void setModule(TenantModule module) {
		this.module = module;
	}

	public Set<TenantRoleFeaturePermission> getRoleFeaturePermissions() {
		return roleFeaturePermissions;
	}

	public void setRoleFeaturePermissions(Set<TenantRoleFeaturePermission> roleFeaturePermissions) {
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
