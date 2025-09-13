package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quote_tasks")
public class QuoteTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id")
    private Quote quote;

    @Column(name = "task_title")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;
    
    // JPA expects these field names in queries
    public String getTask_name() { return taskName; }
    public void setTask_name(String taskName) { this.taskName = taskName; }
    
    public String getTask_description() { return taskDescription; }
    public void setTask_description(String taskDescription) { this.taskDescription = taskDescription; }

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }

    public Quote getQuote() { return quote; }
    public void setQuote(Quote quote) { this.quote = quote; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getTaskDescription() { return taskDescription; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}