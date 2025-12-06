package com.zen.entities.tenant;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "workflow_approval_requests")
public class WorkflowApprovalRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "execution_id", nullable = false)
    private Long executionId;
    
    @Column(name = "approval_process_id", nullable = false)
    private Long approvalProcessId;
    
    @Column(name = "approver_id", nullable = false)
    private Long approverId;
    
    @Column(name = "approval_level")
    private Integer approvalLevel = 1;
    
    @Column(name = "status", length = 50)
    private String status = "PENDING";
    
    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;
    
    @Column(name = "requested_at")
    private LocalDateTime requestedAt;
    
    @Column(name = "responded_at")
    private LocalDateTime respondedAt;
    
    @Column(name = "delegated_to")
    private Long delegatedTo;
    
    public WorkflowApprovalRequest() {}
    
    @PrePersist
    protected void onCreate() {
        requestedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getExecutionId() { return executionId; }
    public void setExecutionId(Long executionId) { this.executionId = executionId; }
    
    public Long getApprovalProcessId() { return approvalProcessId; }
    public void setApprovalProcessId(Long approvalProcessId) { this.approvalProcessId = approvalProcessId; }
    
    public Long getApproverId() { return approverId; }
    public void setApproverId(Long approverId) { this.approverId = approverId; }
    
    public Integer getApprovalLevel() { return approvalLevel; }
    public void setApprovalLevel(Integer approvalLevel) { this.approvalLevel = approvalLevel; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    
    public LocalDateTime getRequestedAt() { return requestedAt; }
    public void setRequestedAt(LocalDateTime requestedAt) { this.requestedAt = requestedAt; }
    
    public LocalDateTime getRespondedAt() { return respondedAt; }
    public void setRespondedAt(LocalDateTime respondedAt) { this.respondedAt = respondedAt; }
    
    public Long getDelegatedTo() { return delegatedTo; }
    public void setDelegatedTo(Long delegatedTo) { this.delegatedTo = delegatedTo; }
}
