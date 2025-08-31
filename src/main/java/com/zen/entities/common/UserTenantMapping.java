package com.zen.entities.common;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "user_tenant_mapping", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"global_user_id", "tenant_id"})
})
public class UserTenantMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "global_user_id", nullable = false)
    private GlobalUser globalUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(name = "role", nullable = false)
    private String role = "USER";

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public GlobalUser getGlobalUser() { return globalUser; }
    public void setGlobalUser(GlobalUser globalUser) { this.globalUser = globalUser; }

    public Tenant getTenant() { return tenant; }
    public void setTenant(Tenant tenant) { this.tenant = tenant; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
