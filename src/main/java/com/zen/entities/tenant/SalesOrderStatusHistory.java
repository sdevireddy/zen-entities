package com.zen.entities.tenant;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.zen.entities.tenant.enums.SalesOrderStatus;

@Entity
@Table(name = "sales_order_status_history")
public class SalesOrderStatusHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_order_id")
    private SalesOrder salesOrder;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "old_status")
    private SalesOrderStatus oldStatus;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "new_status")
    private SalesOrderStatus newStatus;
    
    @Column(name = "changed_by")
    private Long changedBy;
    
    @Column(name = "changed_at")
    private LocalDateTime changedAt = LocalDateTime.now();
    
    private String reason;
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public SalesOrder getSalesOrder() { return salesOrder; }
    public void setSalesOrder(SalesOrder salesOrder) { this.salesOrder = salesOrder; }
    
    public SalesOrderStatus getOldStatus() { return oldStatus; }
    public void setOldStatus(SalesOrderStatus oldStatus) { this.oldStatus = oldStatus; }
    
    public SalesOrderStatus getNewStatus() { return newStatus; }
    public void setNewStatus(SalesOrderStatus newStatus) { this.newStatus = newStatus; }
    
    public Long getChangedBy() { return changedBy; }
    public void setChangedBy(Long changedBy) { this.changedBy = changedBy; }
    
    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
    
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}