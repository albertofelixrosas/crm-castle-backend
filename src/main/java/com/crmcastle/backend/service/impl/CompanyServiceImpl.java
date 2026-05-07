package com.crmcastle.backend.service.impl;

import com.crmcastle.backend.dto.company.CompanyResponse;
import com.crmcastle.backend.entity.Company;
import com.crmcastle.backend.exception.NotFoundException;
import com.crmcastle.backend.mapper.CompanyMapper;
import com.crmcastle.backend.repository.CompanyRepository;
import com.crmcastle.backend.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Page<CompanyResponse> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable).map(companyMapper::toResponse);
    }

    @Override
    public CompanyResponse findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("COMPANY_NOT_FOUND", "Company not found with id " + id));
        return companyMapper.toResponse(company);
    }
}
