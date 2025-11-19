package com.zen.entities.common;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tenant_module_subscriptions")
@Data
public class TenantModuleSubscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "subscribed_at")
    private LocalDateTime subscribedAt = LocalDateTime.now();
    
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_type")
    private SubscriptionType subscriptionType = SubscriptionType.BASIC;
    
    public enum SubscriptionType {
        TRIAL, BASIC, PREMIUM, ENTERPRISE
    }
}