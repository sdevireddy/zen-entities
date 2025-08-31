package com.zen.entities.tenant;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "calls", indexes = {
    @Index(name = "idx_call_owner_id", columnList = "owner_id"),
    @Index(name = "idx_call_account_id", columnList = "account_id"),
    @Index(name = "idx_call_contact_id", columnList = "contact_id")
})
public class Call {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "subject", nullable = false)
    private String subject;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "call_start_time")
    private LocalDateTime callStartTime;
    
    @Column(name = "call_end_time")
    private LocalDateTime callEndTime;
    
    @Column(name = "duration_minutes")
    private Integer durationMinutes;
    
    @Column(name = "call_type")
    @Enumerated(EnumType.STRING)
    private CallType callType = CallType.OUTBOUND;
    
    @Column(name = "call_result")
    @Enumerated(EnumType.STRING)
    private CallResult callResult;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;
    
    @Column(name = "owner_id")
    private Long ownerId;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum CallType { INBOUND, OUTBOUND }
    public enum CallResult { CONNECTED, NO_ANSWER, BUSY, VOICEMAIL, WRONG_NUMBER }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public LocalDateTime getCallStartTime() { return callStartTime; }
    public void setCallStartTime(LocalDateTime callStartTime) { this.callStartTime = callStartTime; }
    
    public LocalDateTime getCallEndTime() { return callEndTime; }
    public void setCallEndTime(LocalDateTime callEndTime) { this.callEndTime = callEndTime; }
    
    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }
    
    public CallType getCallType() { return callType; }
    public void setCallType(CallType callType) { this.callType = callType; }
    
    public CallResult getCallResult() { return callResult; }
    public void setCallResult(CallResult callResult) { this.callResult = callResult; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
    
    public Contact getContact() { return contact; }
    public void setContact(Contact contact) { this.contact = contact; }
    
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}