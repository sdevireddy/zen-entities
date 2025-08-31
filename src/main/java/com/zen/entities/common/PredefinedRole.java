package com.zen.entities.common;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "predefined_roles")
public class PredefinedRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    private String description;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "predefined_permissions")
    @Column(name = "permission")
    private Set<String> permissions = new HashSet<>();
    
    @Column(name = "is_system_role")
    private Boolean isSystemRole = true;
    
    @Column(name = "version")
    private Integer version = 1;
    
    public enum SystemRole {
        SUPER_ADMIN("SUPER_ADMIN", "System Super Administrator"),
        ADMIN("ADMIN", "Tenant Administrator"), 
        MANAGER("MANAGER", "Department Manager"),
        SALES_REP("SALES_REP", "Sales Representative"),
        MARKETING_USER("MARKETING_USER", "Marketing User"),
        VIEWER("VIEWER", "Read-only User");
        
        private final String roleName;
        private final String description;
        
        SystemRole(String roleName, String description) {
            this.roleName = roleName;
            this.description = description;
        }
        
        public String getRoleName() { return roleName; }
        public String getDescription() { return description; }
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Set<String> getPermissions() { return permissions; }
    public void setPermissions(Set<String> permissions) { this.permissions = permissions; }
    
    public Boolean getIsSystemRole() { return isSystemRole; }
    public void setIsSystemRole(Boolean isSystemRole) { this.isSystemRole = isSystemRole; }
    
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
}
