package com.zen.entities.common;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tenant_feature_access")
@Data
public class TenantFeatureAccess {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;
    
    @Column(name = "is_enabled")
    private Boolean isEnabled = true;
    
    @Column(name = "enabled_at")
    private LocalDateTime enabledAt = LocalDateTime.now();
}