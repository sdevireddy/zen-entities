// This TenantBranch entity should be added to zen-entities JAR
// Path: com/zen/entities/tenant/TenantBranch.java

package com.zen.entities.tenant;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "branches")
public class TenantBranch {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;
    
    // Branch Information
    @Column(name = "branch_name", nullable = false, length = 255)
    private String branchName;
    
    @Column(name = "branch_code", length = 50)
    private String branchCode;
    
    @Column(name = "branch_type", length = 50)
    private String branchType; // HEADQUARTERS, REGIONAL, LOCAL, REMOTE, WAREHOUSE, RETAIL, OTHER
    
    // Hierarchy Support
    @Column(name = "parent_branch_id")
    private Long parentBranchId;
    
    @Column(name = "hierarchy_level")
    private Integer hierarchyLevel = 0;
    
    @Column(name = "hierarchy_path", length = 500)
    private String hierarchyPath;
    
    // Location Details
    @Column(name = "address_line1", length = 255)
    private String addressLine1;
    
    @Column(name = "address_line2", length = 255)
    private String addressLine2;
    
    @Column(name = "city", length = 100)
    private String city;
    
    @Column(name = "state", length = 100)
    private String state;
    
    @Column(name = "country", length = 100)
    private String country;
    
    @Column(name = "postal_code", length = 20)
    private String postalCode;
    
    @Column(name = "timezone", length = 50)
    private String timezone = "UTC";
    
    // Contact Information
    @Column(name = "phone", length = 50)
    private String phone;
    
    @Column(name = "email", length = 255)
    private String email;
    
    @Column(name = "fax", length = 50)
    private String fax;
    
    @Column(name = "website", length = 255)
    private String website;
    
    // Branch Manager
    @Column(name = "manager_id")
    private Long managerId;
    
    // Operational Details
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "opening_date")
    private LocalDate openingDate;
    
    @Column(name = "closing_date")
    private LocalDate closingDate;
    
    // Business Hours (JSON)
    @Column(name = "business_hours", columnDefinition = "JSON")
    private String businessHours;
    
    // Additional Metadata
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
    
    @Column(name = "custom_fields", columnDefinition = "JSON")
    private String customFields;
    
    // Audit Fields
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "created_by")
    private Long createdBy;
    
    @Column(name = "updated_by")
    private Long updatedBy;
    
    // Constructors
    public TenantBranch() {}
    
    public TenantBranch(Long tenantId, String branchName, String branchType) {
        this.tenantId = tenantId;
        this.branchName = branchName;
        this.branchType = branchType;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getTenantId() {
        return tenantId;
    }
    
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
    
    public String getBranchName() {
        return branchName;
    }
    
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    public String getBranchCode() {
        return branchCode;
    }
    
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    
    public String getBranchType() {
        return branchType;
    }
    
    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }
    
    public Long getParentBranchId() {
        return parentBranchId;
    }
    
    public void setParentBranchId(Long parentBranchId) {
        this.parentBranchId = parentBranchId;
    }
    
    public Integer getHierarchyLevel() {
        return hierarchyLevel;
    }
    
    public void setHierarchyLevel(Integer hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }
    
    public String getHierarchyPath() {
        return hierarchyPath;
    }
    
    public void setHierarchyPath(String hierarchyPath) {
        this.hierarchyPath = hierarchyPath;
    }
    
    public String getAddressLine1() {
        return addressLine1;
    }
    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    
    public String getAddressLine2() {
        return addressLine2;
    }
    
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getTimezone() {
        return timezone;
    }
    
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFax() {
        return fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public Long getManagerId() {
        return managerId;
    }
    
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public LocalDate getOpeningDate() {
        return openingDate;
    }
    
    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
    
    public LocalDate getClosingDate() {
        return closingDate;
    }
    
    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }
    
    public String getBusinessHours() {
        return businessHours;
    }
    
    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getCustomFields() {
        return customFields;
    }
    
    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Long getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    
    public Long getUpdatedBy() {
        return updatedBy;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
