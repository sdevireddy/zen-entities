package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Table(name = "role_time_restrictions")
public class RoleTimeRestriction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private TenantRoles role;

    @Column(name = "access_start_time")
    private LocalTime accessStartTime;

    @Column(name = "access_end_time")
    private LocalTime accessEndTime;

    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "role_allowed_days")
    private Set<DayOfWeek> allowedDays;

    @Column(name = "timezone")
    private String timezone = "UTC";

    @Column(name = "is_active")
    private Boolean isActive = true;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TenantRoles getRole() { return role; }
    public void setRole(TenantRoles role) { this.role = role; }

    public LocalTime getAccessStartTime() { return accessStartTime; }
    public void setAccessStartTime(LocalTime accessStartTime) { this.accessStartTime = accessStartTime; }

    public LocalTime getAccessEndTime() { return accessEndTime; }
    public void setAccessEndTime(LocalTime accessEndTime) { this.accessEndTime = accessEndTime; }

    public Set<DayOfWeek> getAllowedDays() { return allowedDays; }
    public void setAllowedDays(Set<DayOfWeek> allowedDays) { this.allowedDays = allowedDays; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
