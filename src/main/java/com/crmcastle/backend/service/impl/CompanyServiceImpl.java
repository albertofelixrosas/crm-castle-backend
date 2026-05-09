package com.crmcastle.backend.service.impl;

import com.crmcastle.backend.dto.company.CompanyCreateRequest;
import com.crmcastle.backend.dto.company.CompanyResponse;
import com.crmcastle.backend.dto.company.CompanyUpdateRequest;
import com.crmcastle.backend.entity.Company;
import com.crmcastle.backend.exception.ConflictException;
import com.crmcastle.backend.exception.NotFoundException;
import com.crmcastle.backend.mapper.CompanyMapper;
import com.crmcastle.backend.repository.CompanyRepository;
import com.crmcastle.backend.repository.ContactRepository;
import com.crmcastle.backend.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ContactRepository contactRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Page<CompanyResponse> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable).map(companyMapper::toResponse);
    }

    @Override
    public CompanyResponse findById(Long id) {
        return companyMapper.toResponse(getOrThrow(id));
    }

    @Override
    public CompanyResponse create(CompanyCreateRequest request) {
        Company company = companyMapper.toEntity(request);
        try {
            return companyMapper.toResponse(companyRepository.save(company));
        } catch (DataIntegrityViolationException ex) {
            throw new ConflictException("COMPANY_NAME_DUPLICATE", "A company with this name already exists");
        }
    }

    @Override
    public CompanyResponse update(Long id, CompanyUpdateRequest request) {
        Company company = getOrThrow(id);
        company.setName(request.name());
        company.setIndustry(request.industry());
        company.setWebsite(request.website());
        try {
            return companyMapper.toResponse(companyRepository.save(company));
        } catch (DataIntegrityViolationException ex) {
            throw new ConflictException("COMPANY_NAME_DUPLICATE", "A company with this name already exists");
        }
    }

    @Override
    public void delete(Long id) {
        Company company = getOrThrow(id);
        if (contactRepository.existsByCompany(company)) {
            throw new ConflictException("COMPANY_HAS_CONTACTS", "Cannot delete a company that has associated contacts");
        }
        companyRepository.delete(company);
    }

    private Company getOrThrow(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("COMPANY_NOT_FOUND", "Company not found with id " + id));
    }
}
