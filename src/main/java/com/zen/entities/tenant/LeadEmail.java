package com.zen.entities.tenant;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lead_emails")
public class LeadEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_id", nullable = false)
    private Lead lead;

    private String subject;

    @Column(columnDefinition = "LONGTEXT")
    private String body;

    private String direction; // INBOUND / OUTBOUND
    private String emailFrom;
    private String emailTo;
    private String status;
    private LocalDateTime sentAt;

    public LeadEmail() {
    }

    private LeadEmail(Builder builder) {
        this.id = builder.id;
        this.lead = builder.lead;
        this.subject = builder.subject;
        this.body = builder.body;
        this.direction = builder.direction;
        this.emailFrom = builder.emailFrom;
        this.emailTo = builder.emailTo;
        this.status = builder.status;
        this.sentAt = builder.sentAt;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Lead getLead() {
        return lead;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getDirection() {
        return direction;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    // Builder Class
    public static class Builder {
        private Long id;
        private Lead lead;
        private String subject;
        private String body;
        private String direction;
        private String emailFrom;
        private String emailTo;
        private String status;
        private LocalDateTime sentAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder lead(Lead lead) {
            this.lead = lead;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder direction(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder emailFrom(String emailFrom) {
            this.emailFrom = emailFrom;
            return this;
        }

        public Builder emailTo(String emailTo) {
            this.emailTo = emailTo;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder sentAt(LocalDateTime sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public LeadEmail build() {
            return new LeadEmail(this);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }

	public void setId(Long id) {
		this.id = id;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
    
    
}
