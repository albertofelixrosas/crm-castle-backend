package com.crmcastle.backend.service;

import com.crmcastle.backend.dto.company.CompanyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Page<CompanyResponse> findAll(Pageable pageable);

    CompanyResponse findById(Long id);
}
