package com.zen.entities.common;

public enum MigrationStatus {
    PENDING("Pending", "Migration job is queued and waiting to start"),
    VALIDATING("Validating", "Validating source data and configuration"),
    RUNNING("Running", "Migration is currently in progress"),
    PAUSED("Paused", "Migration has been paused by user"),
    COMPLETED("Completed", "Migration completed successfully"),
    COMPLETED_WITH_WARNINGS("Completed with Warnings", "Migration completed but with some warnings"),
    FAILED("Failed", "Migration failed due to errors"),
    CANCELLED("Cancelled", "Migration was cancelled by user"),
    TIMEOUT("Timeout", "Migration timed out"),
    ROLLBACK("Rolling Back", "Migration is being rolled back"),
    ROLLBACK_COMPLETED("Rollback Completed", "Migration rollback completed");

    private final String displayName;
    private final String description;

    MigrationStatus(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTerminalStatus() {
        return this == COMPLETED || 
               this == COMPLETED_WITH_WARNINGS || 
               this == FAILED || 
               this == CANCELLED || 
               this == TIMEOUT ||
               this == ROLLBACK_COMPLETED;
    }

    public boolean isActiveStatus() {
        return this == RUNNING || 
               this == VALIDATING || 
               this == ROLLBACK;
    }

    public boolean isSuccessStatus() {
        return this == COMPLETED || 
               this == COMPLETED_WITH_WARNINGS;
    }

    public boolean isFailureStatus() {
        return this == FAILED || 
               this == TIMEOUT;
    }

    public boolean canBeCancelled() {
        return this == PENDING || 
               this == VALIDATING || 
               this == RUNNING || 
               this == PAUSED;
    }

    public boolean canBePaused() {
        return this == RUNNING || 
               this == VALIDATING;
    }

    public boolean canBeResumed() {
        return this == PAUSED;
    }

    public boolean canBeRetried() {
        return this == FAILED || 
               this == TIMEOUT || 
               this == CANCELLED;
    }

    public boolean canBeRolledBack() {
        return this == COMPLETED || 
               this == COMPLETED_WITH_WARNINGS || 
               this == FAILED;
    }

    public String getStatusColor() {
        return switch (this) {
            case PENDING -> "#FFA500"; // Orange
            case VALIDATING -> "#1E90FF"; // DodgerBlue
            case RUNNING -> "#32CD32"; // LimeGreen
            case PAUSED -> "#FFD700"; // Gold
            case COMPLETED -> "#008000"; // Green
            case COMPLETED_WITH_WARNINGS -> "#FF8C00"; // DarkOrange
            case FAILED -> "#DC143C"; // Crimson
            case CANCELLED -> "#808080"; // Gray
            case TIMEOUT -> "#B22222"; // FireBrick
            case ROLLBACK -> "#9932CC"; // DarkOrchid
            case ROLLBACK_COMPLETED -> "#4B0082"; // Indigo
        };
    }

    public String getStatusIcon() {
        return switch (this) {
            case PENDING -> "⏳";
            case VALIDATING -> "🔍";
            case RUNNING -> "⚡";
            case PAUSED -> "⏸️";
            case COMPLETED -> "✅";
            case COMPLETED_WITH_WARNINGS -> "⚠️";
            case FAILED -> "❌";
            case CANCELLED -> "🚫";
            case TIMEOUT -> "⏰";
            case ROLLBACK -> "🔄";
            case ROLLBACK_COMPLETED -> "↩️";
        };
    }
}