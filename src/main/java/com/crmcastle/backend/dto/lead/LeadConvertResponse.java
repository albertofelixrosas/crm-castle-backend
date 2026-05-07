package com.crmcastle.backend.dto.lead;

public record LeadConvertResponse(
        Long leadId,
        Long contactId,
        Long companyId
) {
}
