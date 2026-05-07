package com.crmcastle.backend.dto.lead;

import com.crmcastle.backend.entity.LeadStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LeadUpdateRequest(
        @NotBlank @Size(max = 80) String firstName,
        @NotBlank @Size(max = 80) String lastName,
        @NotBlank @Email @Size(max = 120) String email,
        @Size(max = 40) String phone,
        @NotBlank @Size(max = 120) String companyName,
        @Size(max = 60) String source,
        @NotNull LeadStatus status,
        String notes
) {
}
