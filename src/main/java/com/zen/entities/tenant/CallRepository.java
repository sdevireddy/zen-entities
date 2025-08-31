package com.zen.entities.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CallRepository extends JpaRepository<Call, Long> {
    List<Call> findByOwnerId(Long ownerId);
    long countByOwnerId(Long ownerId);
    List<Call> findByAccountId(Long accountId);
    List<Call> findByContactId(Long contactId);
}