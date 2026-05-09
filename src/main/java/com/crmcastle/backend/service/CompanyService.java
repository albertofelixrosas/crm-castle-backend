package com.crmcastle.backend.service;

import com.crmcastle.backend.dto.company.CompanyCreateRequest;
import com.crmcastle.backend.dto.company.CompanyResponse;
import com.crmcastle.backend.dto.company.CompanyUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Page<CompanyResponse> findAll(Pageable pageable);

    CompanyResponse findById(Long id);

    CompanyResponse create(CompanyCreateRequest request);

    CompanyResponse update(Long id, CompanyUpdateRequest request);

    void delete(Long id);
}
