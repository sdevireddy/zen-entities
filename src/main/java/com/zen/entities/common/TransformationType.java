package com.zen.entities.common;

public enum TransformationType {
    DIRECT("Direct Mapping", "Direct field-to-field mapping without transformation"),
    FUNCTION("Function Transform", "Apply a transformation function to the field value"),
    LOOKUP("Lookup Transform", "Look up value from a reference table or mapping"),
    CONDITIONAL("Conditional Transform", "Apply transformation based on conditions"),
    CUSTOM("Custom Transform", "Custom transformation logic"),
    CONCATENATE("Concatenate", "Combine multiple source fields into one target field"),
    SPLIT("Split", "Split one source field into multiple target fields"),
    FORMAT("Format", "Format the field value (date, number, text formatting)"),
    DEFAULT_VALUE("Default Value", "Use default value if source field is empty"),
    CALCULATE("Calculate", "Calculate value based on formula or expression");

    private final String displayName;
    private final String description;

    TransformationType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public boolean requiresConfiguration() {
        return this != DIRECT;
    }

    public boolean supportsMultipleSourceFields() {
        return this == CONCATENATE || 
               this == CONDITIONAL || 
               this == CUSTOM || 
               this == CALCULATE;
    }

    public boolean supportsMultipleTargetFields() {
        return this == SPLIT || 
               this == CUSTOM;
    }

    public String[] getRequiredConfigurationFields() {
        return switch (this) {
            case DIRECT -> new String[]{};
            case FUNCTION -> new String[]{"function_name", "parameters"};
            case LOOKUP -> new String[]{"lookup_table", "lookup_key", "lookup_value"};
            case CONDITIONAL -> new String[]{"conditions", "true_value", "false_value"};
            case CUSTOM -> new String[]{"custom_logic", "parameters"};
            case CONCATENATE -> new String[]{"source_fields", "separator", "format"};
            case SPLIT -> new String[]{"delimiter", "target_fields", "max_splits"};
            case FORMAT -> new String[]{"format_type", "format_pattern", "locale"};
            case DEFAULT_VALUE -> new String[]{"default_value", "condition"};
            case CALCULATE -> new String[]{"formula", "variables", "result_type"};
        };
    }

    public String getConfigurationExample() {
        return switch (this) {
            case DIRECT -> "{}";
            case FUNCTION -> "{\"function_name\": \"toLowerCase\", \"parameters\": {}}";
            case LOOKUP -> "{\"lookup_table\": \"country_codes\", \"lookup_key\": \"country_name\", \"lookup_value\": \"country_code\"}";
            case CONDITIONAL -> "{\"conditions\": [{\"field\": \"status\", \"operator\": \"equals\", \"value\": \"active\"}], \"true_value\": \"Active\", \"false_value\": \"Inactive\"}";
            case CUSTOM -> "{\"custom_logic\": \"extractEmailDomain\", \"parameters\": {\"format\": \"lowercase\"}}";
            case CONCATENATE -> "{\"source_fields\": [\"first_name\", \"last_name\"], \"separator\": \" \", \"format\": \"{0} {1}\"}";
            case SPLIT -> "{\"delimiter\": \" \", \"target_fields\": [\"first_name\", \"last_name\"], \"max_splits\": 1}";
            case FORMAT -> "{\"format_type\": \"date\", \"format_pattern\": \"yyyy-MM-dd\", \"locale\": \"en_US\"}";
            case DEFAULT_VALUE -> "{\"default_value\": \"Unknown\", \"condition\": \"isEmpty\"}";
            case CALCULATE -> "{\"formula\": \"${annual_revenue} / ${employees}\", \"variables\": [\"annual_revenue\", \"employees\"], \"result_type\": \"decimal\"}";
        };
    }
}