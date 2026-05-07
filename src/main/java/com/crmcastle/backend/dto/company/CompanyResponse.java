package com.crmcastle.backend.dto.company;

import java.time.OffsetDateTime;

public record CompanyResponse(
        Long id,
        String name,
        String industry,
        String website,
        OffsetDateTime createdAt
) {
}
