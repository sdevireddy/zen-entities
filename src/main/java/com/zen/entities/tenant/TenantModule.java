package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tenant_modules")

public class TenantModule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String moduleKey;
	private String name;
	private String description;

	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<TenantFeature> features = new HashSet<>();

	public TenantModule() {
	}

	public TenantModule(String moduleKey, String name) {
		this.moduleKey = moduleKey;
		this.name = name;
	}
	
	public TenantModule(String moduleKey, String name,String descripton) {
		this.moduleKey = moduleKey;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getModuleKey() {
		return moduleKey;
	}

	public void setModuleKey(String moduleKey) {
		this.moduleKey = moduleKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<TenantFeature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<TenantFeature> features) {
		this.features = features;
	}
}
