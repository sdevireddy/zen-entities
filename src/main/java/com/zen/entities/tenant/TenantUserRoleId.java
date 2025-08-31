package com.zen.entities.tenant;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TenantUserRoleId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    public TenantUserRoleId() {
    }

    public TenantUserRoleId(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    // equals and hashCode must be overridden for composite key

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TenantUserRoleId)) return false;
        TenantUserRoleId that = (TenantUserRoleId) o;
        return userId.equals(that.userId) && roleId.equals(that.roleId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode() + roleId.hashCode();
    }

    // getters and setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
