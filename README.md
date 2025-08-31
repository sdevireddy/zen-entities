# Zen Entities

Shared entity library for all Zen microservices.

## Usage

Add this dependency to your module's pom.xml:

```xml
<dependency>
    <groupId>com.zen</groupId>
    <artifactId>zen-entities</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Build

```bash
mvn clean install
```

## Package Structure

### Common Schema Entities (`com.zen.entities.common`)
- CommonModule, Feature, FieldPermission, Fields
- FreeEmailDomain, GlobalUser, PermissionBundle, Permissions
- PredefinedRole, RoleFeaturePermission, RoleModulePermission, Roles
- Tenant, TenantDomain, TenantDomainVerification, UserTenantMapping

### Tenant Schema Entities (`com.zen.entities.tenant`)
- AuditLog, RoleTimeRestriction, TemporaryPermission
- TenantBranch, TenantCountry, TenantFeature, TenantFieldPermission
- TenantFields, TenantLocation, TenantModule, TenantPermissionBundle
- TenantPermissions, TenantRecordPermission, TenantRoleFeaturePermission
- TenantRoleModulePermission, TenantRoles, TenantUserRole, TenantUserRoleId
- Territory, UserInvitation, UserRoleBranchLocation, UserTerritoryRole, ZenUser

## Import Examples

```java
// Common entities
import com.zen.entities.common.Tenant;
import com.zen.entities.common.GlobalUser;

// Tenant entities  
import com.zen.entities.tenant.ZenUser;
import com.zen.entities.tenant.TenantRoles;
```