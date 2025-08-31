package com.zen.entities.tenant;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quote_approvals")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalId;

    private Long quoteId;
    private Long approverId;
    private String status; // PENDING | APPROVED | REJECTED
    private String remarks;
    private LocalDateTime actedAt;
    private LocalDateTime createdAt;
}
