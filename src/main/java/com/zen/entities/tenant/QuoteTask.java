package com.zen.entities.tenant;

import java.time.LocalDateTime;

import com.zen.entities.tenant.enums.TaskStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "quote_tasks")
public class QuoteTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long taskId;

	@ManyToOne
	@JoinColumn(name = "quote_id", nullable = false)
	private Quote quote;

	@Column(name = "task_name", nullable = false, length = 255)
	private String taskName;

	@Column(name = "task_description")
	private String taskDescription;

	@Column(name = "due_date")
	private LocalDateTime dueDate;

	@Column(name = "assigned_to")
	private Long assignedTo;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 50)
	private TaskStatus status;

	// Getters & Setters
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
}
