package com.zen.entities.tenant;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "workflow_nodes")
public class WorkflowNode {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "workflow_id", nullable = false)
    private Long workflowId;
    
    @Column(name = "node_key", nullable = false, length = 100)
    private String nodeKey;
    
    @Column(name = "node_type", nullable = false, length = 50)
    private String nodeType;
    
    @Column(name = "node_config", columnDefinition = "JSON")
    private String nodeConfig;
    
    @Column(name = "position_x")
    private Integer positionX;
    
    @Column(name = "position_y")
    private Integer positionY;
    
    @Column(name = "next_node_id")
    private Long nextNodeId;
    
    @Column(name = "true_node_id")
    private Long trueNodeId;
    
    @Column(name = "false_node_id")
    private Long falseNodeId;
    
    @Column(name = "sort_order")
    private Integer sortOrder = 0;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    public WorkflowNode() {}
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getWorkflowId() { return workflowId; }
    public void setWorkflowId(Long workflowId) { this.workflowId = workflowId; }
    
    public String getNodeKey() { return nodeKey; }
    public void setNodeKey(String nodeKey) { this.nodeKey = nodeKey; }
    
    public String getNodeType() { return nodeType; }
    public void setNodeType(String nodeType) { this.nodeType = nodeType; }
    
    public String getNodeConfig() { return nodeConfig; }
    public void setNodeConfig(String nodeConfig) { this.nodeConfig = nodeConfig; }
    
    public Integer getPositionX() { return positionX; }
    public void setPositionX(Integer positionX) { this.positionX = positionX; }
    
    public Integer getPositionY() { return positionY; }
    public void setPositionY(Integer positionY) { this.positionY = positionY; }
    
    public Long getNextNodeId() { return nextNodeId; }
    public void setNextNodeId(Long nextNodeId) { this.nextNodeId = nextNodeId; }
    
    public Long getTrueNodeId() { return trueNodeId; }
    public void setTrueNodeId(Long trueNodeId) { this.trueNodeId = trueNodeId; }
    
    public Long getFalseNodeId() { return falseNodeId; }
    public void setFalseNodeId(Long falseNodeId) { this.falseNodeId = falseNodeId; }
    
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
