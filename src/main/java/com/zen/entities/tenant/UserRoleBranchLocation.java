package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tenant_user_role_branch_location")

public class UserRoleBranchLocation {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ZenUser user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private TenantRoles roles;

    @ManyToOne
    private TenantBranch branch;

    @ManyToOne
    private TenantLocation location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZenUser getUser() {
		return user;
	}

	public void setUser(ZenUser user) {
		this.user = user;
	}

	public TenantRoles getRole() {
		return roles;
	}

	public void setRole(TenantRoles role) {
		this.roles = roles;
	}

	public TenantBranch getBranch() {
		return branch;
	}

	public void setBranch(TenantBranch branch) {
		this.branch = branch;
	}

	public TenantLocation getLocation() {
		return location;
	}

	public void setLocation(TenantLocation location) {
		this.location = location;
	}


}
