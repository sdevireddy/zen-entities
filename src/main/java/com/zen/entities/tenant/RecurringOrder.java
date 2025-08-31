package com.zen.entities.tenant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "recurring_orders")
public class RecurringOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_order_id", nullable = false)
    private SalesOrder templateOrder;
    
    @Column(name = "subscription_name", nullable = false)
    private String subscriptionName;
    
    @Enumerated(EnumType.STRING)
    private RecurrenceType recurrenceType;
    
    @Column(name = "recurrence_interval")
    private Integer recurrenceInterval = 1;
    
    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @Column(name = "next_execution_date")
    private LocalDate nextExecutionDate;
    
    @Column(name = "last_execution_date")
    private LocalDate lastExecutionDate;
    
    @Enumerated(EnumType.STRING)
    private RecurringStatus status = RecurringStatus.ACTIVE;
    
    @Column(name = "max_occurrences")
    private Integer maxOccurrences;
    
    @Column(name = "current_occurrences")
    private Integer currentOccurrences = 0;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "created_by")
    private Long createdBy;

    public enum RecurrenceType { 
        DAILY, WEEKLY, MONTHLY, QUARTERLY, YEARLY 
    }
    
    public enum RecurringStatus { 
        ACTIVE, PAUSED, COMPLETED, CANCELLED 
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public SalesOrder getTemplateOrder() { return templateOrder; }
    public void setTemplateOrder(SalesOrder templateOrder) { this.templateOrder = templateOrder; }
    
    public String getSubscriptionName() { return subscriptionName; }
    public void setSubscriptionName(String subscriptionName) { this.subscriptionName = subscriptionName; }
    
    public RecurrenceType getRecurrenceType() { return recurrenceType; }
    public void setRecurrenceType(RecurrenceType recurrenceType) { this.recurrenceType = recurrenceType; }
    
    public Integer getRecurrenceInterval() { return recurrenceInterval; }
    public void setRecurrenceInterval(Integer recurrenceInterval) { this.recurrenceInterval = recurrenceInterval; }
    
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    
    public LocalDate getNextExecutionDate() { return nextExecutionDate; }
    public void setNextExecutionDate(LocalDate nextExecutionDate) { this.nextExecutionDate = nextExecutionDate; }
    
    public LocalDate getLastExecutionDate() { return lastExecutionDate; }
    public void setLastExecutionDate(LocalDate lastExecutionDate) { this.lastExecutionDate = lastExecutionDate; }
    
    public RecurringStatus getStatus() { return status; }
    public void setStatus(RecurringStatus status) { this.status = status; }
    
    public Integer getMaxOccurrences() { return maxOccurrences; }
    public void setMaxOccurrences(Integer maxOccurrences) { this.maxOccurrences = maxOccurrences; }
    
    public Integer getCurrentOccurrences() { return currentOccurrences; }
    public void setCurrentOccurrences(Integer currentOccurrences) { this.currentOccurrences = currentOccurrences; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
}