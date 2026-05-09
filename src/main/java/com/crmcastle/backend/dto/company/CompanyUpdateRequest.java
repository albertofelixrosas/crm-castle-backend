package com.crmcastle.backend.dto.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CompanyUpdateRequest(
        @NotBlank @Size(max = 140) String name,
        @Size(max = 80) String industry,
        @Size(max = 180) String website
) {
}
