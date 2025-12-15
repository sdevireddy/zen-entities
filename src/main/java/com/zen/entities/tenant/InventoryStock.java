package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_stock")
public class InventoryStock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;
    
    @Column(name = "item_id", nullable = false)
    private Long itemId;
    
    @Column(name = "quantity_on_hand")
    private Integer quantityOnHand = 0;
    
    @Column(name = "quantity_reserved")
    private Integer quantityReserved = 0;
    
    @Column(name = "quantity_available", insertable = false, updatable = false)
    private Integer quantityAvailable; // Generated column
    
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    private Warehouse warehouse;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private InventoryItem inventoryItem;
    
    // Constructors
    public InventoryStock() {
        this.lastUpdated = LocalDateTime.now();
    }
    
    public InventoryStock(Long warehouseId, Long itemId) {
        this();
        this.warehouseId = warehouseId;
        this.itemId = itemId;
    }
    
    public InventoryStock(Long warehouseId, Long itemId, Integer quantityOnHand, Integer quantityReserved) {
        this();
        this.warehouseId = warehouseId;
        this.itemId = itemId;
        this.quantityOnHand = quantityOnHand;
        this.quantityReserved = quantityReserved;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getWarehouseId() { return warehouseId; }
    public void setWarehouseId(Long warehouseId) { this.warehouseId = warehouseId; }
    
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    
    public Integer getQuantityOnHand() { return quantityOnHand; }
    public void setQuantityOnHand(Integer quantityOnHand) { this.quantityOnHand = quantityOnHand; }
    
    public Integer getQuantityReserved() { return quantityReserved; }
    public void setQuantityReserved(Integer quantityReserved) { this.quantityReserved = quantityReserved; }
    
    public Integer getQuantityAvailable() { return quantityAvailable; }
    public void setQuantityAvailable(Integer quantityAvailable) { this.quantityAvailable = quantityAvailable; }
    
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
    
    public Warehouse getWarehouse() { return warehouse; }
    public void setWarehouse(Warehouse warehouse) { this.warehouse = warehouse; }
    
    public InventoryItem getInventoryItem() { return inventoryItem; }
    public void setInventoryItem(InventoryItem inventoryItem) { this.inventoryItem = inventoryItem; }
    
    @PreUpdate
    public void preUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }
}