package com.zen.entities.tenant;

import com.zen.entities.tenant.TenantRoles;
import com.zen.entities.tenant.TenantUserRoleId;
import com.zen.entities.tenant.ZenUser;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_roles")
public class TenantUserRole {

    @EmbeddedId
    private TenantUserRoleId id = new TenantUserRoleId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private ZenUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private TenantRoles role;

    public TenantUserRole() {
    }

    public TenantUserRole(ZenUser user, TenantRoles role) {
        this.user = user;
        this.role = role;
        this.id = new TenantUserRoleId(user.getId(), role.getId());
    }

    public TenantUserRoleId getId() {
        return id;
    }

    public void setId(TenantUserRoleId id) {
        this.id = id;
    }

    public ZenUser getUser() {
        return user;
    }

    public void setUser(ZenUser user) {
        this.user = user;
    }

    public TenantRoles getRole() {
        return role;
    }

    public void setRole(TenantRoles role) {
        this.role = role;
    }
}
