package com.zen.entities.tenant;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quote_audit")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    private Long quoteId;
    private String action; // CREATED | UPDATED | SUBMITTED | APPROVED | ...
    
    @Lob
    private String details;

    private Long actorUserId;
    private LocalDateTime createdAt;
}
