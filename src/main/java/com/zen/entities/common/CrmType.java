package com.zen.entities.common;

public enum CrmType {
    SALESFORCE("Salesforce", "salesforce", "https://login.salesforce.com"),
    HUBSPOT("HubSpot", "hubspot", "https://api.hubapi.com"),
    PIPEDRIVE("Pipedrive", "pipedrive", "https://api.pipedrive.com/v1"),
    ZOHO("Zoho CRM", "zoho", "https://www.zohoapis.com/crm/v2"),
    BITRIX24("Bitrix24", "bitrix24", "https://your-domain.bitrix24.com/rest"),
    AGILE_CRM("Agile CRM", "agile_crm", "https://your-domain.agilecrm.com/dev/api"),
    DYNAMICS365("Microsoft Dynamics 365", "dynamics365", "https://your-org.api.crm.dynamics.com"),
    SUGARCRM("SugarCRM", "sugarcrm", "https://your-instance.sugarcrm.com"),
    INSIGHTLY("Insightly", "insightly", "https://api.insightly.com/v3.1"),
    FRESHWORKS("Freshworks CRM", "freshworks", "https://your-domain.freshsales.io/api"),
    CSV("CSV File", "csv", "file://");

    private final String displayName;
    private final String key;
    private final String defaultApiUrl;

    CrmType(String displayName, String key, String defaultApiUrl) {
        this.displayName = displayName;
        this.key = key;
        this.defaultApiUrl = defaultApiUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getKey() {
        return key;
    }

    public String getDefaultApiUrl() {
        return defaultApiUrl;
    }

    public static CrmType fromKey(String key) {
        for (CrmType type : values()) {
            if (type.key.equalsIgnoreCase(key)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown CRM type key: " + key);
    }

    public static CrmType fromDisplayName(String displayName) {
        for (CrmType type : values()) {
            if (type.displayName.equalsIgnoreCase(displayName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown CRM type display name: " + displayName);
    }

    public boolean isApiBasedCrm() {
        return this != CSV;
    }

    public boolean isFileBasedCrm() {
        return this == CSV;
    }

    public boolean requiresOAuth() {
        return this == SALESFORCE || this == HUBSPOT || this == ZOHO || this == DYNAMICS365;
    }

    public boolean supportsRealTimeSync() {
        return this == SALESFORCE || this == HUBSPOT || this == PIPEDRIVE || this == ZOHO;
    }

    public boolean supportsBulkApi() {
        return this == SALESFORCE || this == HUBSPOT || this == ZOHO;
    }

    public int getDefaultRateLimitDelayMs() {
        return switch (this) {
            case SALESFORCE -> 200;
            case HUBSPOT -> 100;
            case PIPEDRIVE -> 50;
            case ZOHO -> 150;
            case BITRIX24 -> 300;
            case AGILE_CRM -> 250;
            case DYNAMICS365 -> 180;
            case SUGARCRM -> 200;
            case INSIGHTLY -> 100;
            case FRESHWORKS -> 120;
            case CSV -> 0;
        };
    }

    public int getDefaultBatchSize() {
        return switch (this) {
            case SALESFORCE -> 2000; // Supports bulk API
            case HUBSPOT -> 1000;
            case PIPEDRIVE -> 500;
            case ZOHO -> 1000;
            case BITRIX24 -> 200; // More conservative due to API limitations
            case AGILE_CRM -> 100; // Limited API
            case DYNAMICS365 -> 1000;
            case SUGARCRM -> 500;
            case INSIGHTLY -> 500;
            case FRESHWORKS -> 500;
            case CSV -> 5000; // File-based, can handle larger batches
        };
    }

    public String[] getSupportedEntityTypes() {
        return switch (this) {
            case SALESFORCE -> new String[]{"accounts", "contacts", "leads", "opportunities", "products", "tasks", "events", "campaigns"};
            case HUBSPOT -> new String[]{"companies", "contacts", "deals", "products", "tasks", "notes"};
            case PIPEDRIVE -> new String[]{"organizations", "persons", "deals", "products", "activities", "notes"};
            case ZOHO -> new String[]{"accounts", "contacts", "leads", "deals", "products", "tasks", "events", "campaigns"};
            case BITRIX24 -> new String[]{"companies", "contacts", "leads", "deals", "products", "tasks"};
            case AGILE_CRM -> new String[]{"companies", "contacts", "deals", "tasks", "notes"};
            case DYNAMICS365 -> new String[]{"accounts", "contacts", "leads", "opportunities", "products", "tasks", "appointments"};
            case SUGARCRM -> new String[]{"accounts", "contacts", "leads", "opportunities", "products", "tasks", "meetings"};
            case INSIGHTLY -> new String[]{"organizations", "contacts", "leads", "opportunities", "products", "tasks", "events"};
            case FRESHWORKS -> new String[]{"accounts", "contacts", "leads", "deals", "products", "tasks", "appointments"};
            case CSV -> new String[]{"accounts", "contacts", "leads", "deals", "products", "activities", "users", "custom"};
        };
    }
}