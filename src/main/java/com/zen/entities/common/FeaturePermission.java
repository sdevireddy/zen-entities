package com.zen.entities.common;

import jakarta.persistence.*;

@Entity
@Table(name = "feature_permissions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"feature_id", "permission_id"})
})
public class FeaturePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id")
    private Feature feature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private Permissions permission;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Feature getFeature() { return feature; }
    public void setFeature(Feature feature) { this.feature = feature; }

    public Permissions getPermission() { return permission; }
    public void setPermission(Permissions permission) { this.permission = permission; }
}