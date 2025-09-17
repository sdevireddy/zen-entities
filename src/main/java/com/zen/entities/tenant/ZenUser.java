package com.zen.entities.tenant;

import com.zen.entities.tenant.ZenUser;
import com.zen.entities.tenant.enums.ServiceContext;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zen.entities.common.Roles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class ZenUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 100)
	private String username;

	@Column(nullable = false, unique = true, length = 255)
	private String email;

	@JsonIgnore
	@Column(name = "password", length = 255)
	private String password;

	@Column(name = "first_name", length = 100)
	private String firstName;

	@Column(name = "last_name", length = 100)
	private String lastName;

	@Column(name = "phone_number", length = 50)
	private String phoneNumber;

	@Column(name = "is_active")
	private Boolean isActive = true;

	@Column(name = "last_login")
	private Instant lastLogin;

	@Column(name = "created_at", nullable = false, updatable = false)
	private Instant createdAt = Instant.now();

	@Column(name = "updated_at")
	private Instant updatedAt;

	@Column(name = "profile_picture_url", length = 512)
	private String profilePictureUrl;

	@Column(length = 50)
	private String timezone;

	@Column(name = "language_preference", length = 10)
	private String languagePreference;

	@Column(length = 100)
	private String department;

	@Column(name = "job_title", length = 100)
	private String jobTitle;

	@Column(name = "manager_id")
	private Long managerId;

	@Column(length = 255)
	private String address;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(length = 20)
	private String gender;

	@Column(name = "last_password_change")
	private Instant lastPasswordChange;

	@Column(name = "failed_login_attempts")
	private Integer failedLoginAttempts = 0;

	@Column(name = "account_locked")
	private Boolean accountLocked = false;

	@Column(name = "two_factor_enabled")
	private Boolean twoFactorEnabled = false;

	@Column(name = "security_question", length = 255)
	private String securityQuestion;

	@Column(name = "security_answer_hash", length = 255)
	private String securityAnswerHash;

	@Column(name = "firstlogin")
	private boolean firstLogin = true;

	// Service contexts now resolved dynamically - no database storage needed

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "users_roles",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<TenantRoles> roles = new HashSet<>();

	public Set<TenantRoles> getRoles() {
	    return roles;
	}
	public void setRoles(Set<TenantRoles> roles) {
	    this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private TenantCountry country;

	@ManyToMany
	@JoinTable(name = "user_branches", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "branch_id"))
	private Set<TenantBranch> branches = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "user_locations", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
	private Set<TenantLocation> locations = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserRoleBranchLocation> userRoleBranchLocations = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<TenantRecordPermission> recordPermissions = new HashSet<>();

	// Constructors
	public ZenUser() {
	}

	// --- Getters & Setters ---
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordHash) {
		this.password = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Instant getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Instant lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getLanguagePreference() {
		return languagePreference;
	}

	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Instant getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(Instant lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public Integer getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(Integer failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Boolean getTwoFactorEnabled() {
		return twoFactorEnabled;
	}

	public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswerHash() {
		return securityAnswerHash;
	}

	public void setSecurityAnswerHash(String securityAnswerHash) {
		this.securityAnswerHash = securityAnswerHash;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}


	public TenantCountry getCountry() {
		return country;
	}

	public void setCountry(TenantCountry country) {
		this.country = country;
	}

	public Set<TenantBranch> getBranches() {
		return branches;
	}

	public void setBranches(Set<TenantBranch> branches) {
		this.branches = branches;
	}

	public Set<TenantLocation> getLocations() {
		return locations;
	}

	public void setLocations(Set<TenantLocation> locations) {
		this.locations = locations;
	}

	public Set<UserRoleBranchLocation> getUserRoleBranchLocations() {
		return userRoleBranchLocations;
	}

	public void setUserRoleBranchLocations(Set<UserRoleBranchLocation> userRoleBranchLocations) {
		this.userRoleBranchLocations = userRoleBranchLocations;
	}

	public Set<TenantRecordPermission> getRecordPermissions() {
		return recordPermissions;
	}

	public void setRecordPermissions(Set<TenantRecordPermission> recordPermissions) {
		this.recordPermissions = recordPermissions;
	}

	// Service context getters/setters removed - now resolved dynamically
}
