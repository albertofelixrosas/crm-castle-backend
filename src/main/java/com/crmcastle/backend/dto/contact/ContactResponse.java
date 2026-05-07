package com.crmcastle.backend.dto.contact;

import java.time.OffsetDateTime;

public record ContactResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        Long companyId,
        String companyName,
        OffsetDateTime createdAt
) {
}
