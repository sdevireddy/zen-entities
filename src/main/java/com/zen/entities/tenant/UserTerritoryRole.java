package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_territory_roles")
public class UserTerritoryRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private ZenUser user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private TenantRoles role;

    @ManyToOne
    @JoinColumn(name = "territory_id", nullable = false)
    private Territory territory;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt = LocalDateTime.now();

    @Column(name = "assigned_by")
    private Long assignedBy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ZenUser getUser() { return user; }
    public void setUser(ZenUser user) { this.user = user; }

    public TenantRoles getRole() { return role; }
    public void setRole(TenantRoles role) { this.role = role; }

    public Territory getTerritory() { return territory; }
    public void setTerritory(Territory territory) { this.territory = territory; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public LocalDateTime getAssignedAt() { return assignedAt; }
    public void setAssignedAt(LocalDateTime assignedAt) { this.assignedAt = assignedAt; }

    public Long getAssignedBy() { return assignedBy; }
    public void setAssignedBy(Long assignedBy) { this.assignedBy = assignedBy; }
}
