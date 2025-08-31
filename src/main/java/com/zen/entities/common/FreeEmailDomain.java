package com.zen.entities.common;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "free_email_domains")
public class FreeEmailDomain {

    @Id
    @Column(name = "domain_name", nullable = false, length = 255)
    private String domainName;

    @Column(name = "last_checked")
    private LocalDateTime lastChecked = LocalDateTime.now();

    // --- Getters and Setters ---
    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public LocalDateTime getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDateTime lastChecked) {
        this.lastChecked = lastChecked;
    }
}
