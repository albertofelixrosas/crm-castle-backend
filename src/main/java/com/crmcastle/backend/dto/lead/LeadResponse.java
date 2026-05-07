package com.crmcastle.backend.dto.lead;

import com.crmcastle.backend.entity.LeadStatus;
import java.time.OffsetDateTime;

public record LeadResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String companyName,
        String source,
        LeadStatus status,
        String notes,
        OffsetDateTime createdAt
) {
}
