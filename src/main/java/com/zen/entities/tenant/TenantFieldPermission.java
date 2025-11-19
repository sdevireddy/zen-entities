package com.zen.entities.tenant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tenant_field_permissions")

public class TenantFieldPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "field_name")
    private String fieldName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private TenantRoles role;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private TenantModule module;

    @ManyToOne
    @JoinColumn(name = "feature_id")
    private TenantFeature feature;

    private String action; // view/edit/create etc.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

    
    
}
