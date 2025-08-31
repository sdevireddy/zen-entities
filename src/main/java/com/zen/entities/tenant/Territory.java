package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "territories")
public class Territory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "territory_code", unique = true)
    private String territoryCode;

    @Enumerated(EnumType.STRING)
    private TerritoryType type;

    @Column(name = "parent_territory_id")
    private Long parentTerritoryId;

    @ElementCollection
    @CollectionTable(name = "territory_countries")
    private Set<String> countries;

    @ElementCollection
    @CollectionTable(name = "territory_regions")
    private Set<String> regions;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum TerritoryType {
        GLOBAL, REGION, COUNTRY, STATE, CITY
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTerritoryCode() { return territoryCode; }
    public void setTerritoryCode(String territoryCode) { this.territoryCode = territoryCode; }

    public TerritoryType getType() { return type; }
    public void setType(TerritoryType type) { this.type = type; }

    public Long getParentTerritoryId() { return parentTerritoryId; }
    public void setParentTerritoryId(Long parentTerritoryId) { this.parentTerritoryId = parentTerritoryId; }

    public Set<String> getCountries() { return countries; }
    public void setCountries(Set<String> countries) { this.countries = countries; }

    public Set<String> getRegions() { return regions; }
    public void setRegions(Set<String> regions) { this.regions = regions; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
