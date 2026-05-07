package com.crmcastle.backend.service.impl;

import com.crmcastle.backend.dto.lead.LeadConvertResponse;
import com.crmcastle.backend.dto.lead.LeadCreateRequest;
import com.crmcastle.backend.dto.lead.LeadResponse;
import com.crmcastle.backend.dto.lead.LeadUpdateRequest;
import com.crmcastle.backend.entity.Company;
import com.crmcastle.backend.entity.Contact;
import com.crmcastle.backend.entity.Lead;
import com.crmcastle.backend.entity.LeadStatus;
import com.crmcastle.backend.exception.ConflictException;
import com.crmcastle.backend.exception.NotFoundException;
import com.crmcastle.backend.mapper.LeadMapper;
import com.crmcastle.backend.repository.CompanyRepository;
import com.crmcastle.backend.repository.ContactRepository;
import com.crmcastle.backend.repository.LeadRepository;
import com.crmcastle.backend.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final LeadMapper leadMapper;

    @Override
    public LeadResponse create(LeadCreateRequest request) {
        Lead lead = leadMapper.toEntity(request);
        lead.setStatus(LeadStatus.NEW);
        return leadMapper.toResponse(leadRepository.save(lead));
    }

    @Override
    public Page<LeadResponse> findAll(Pageable pageable) {
        return leadRepository.findAll(pageable).map(leadMapper::toResponse);
    }

    @Override
    public LeadResponse findById(Long id) {
        Lead lead = getLeadOrThrow(id);
        return leadMapper.toResponse(lead);
    }

    @Override
    public LeadResponse update(Long id, LeadUpdateRequest request) {
        Lead lead = getLeadOrThrow(id);
        if (lead.getStatus() == LeadStatus.CONVERTED) {
            throw new ConflictException("LEAD_EDIT_FORBIDDEN_CONVERTED", "Converted lead cannot be edited");
        }

        lead.setFirstName(request.firstName());
        lead.setLastName(request.lastName());
        lead.setEmail(request.email());
        lead.setPhone(request.phone());
        lead.setCompanyName(request.companyName());
        lead.setSource(request.source());
        lead.setStatus(request.status());
        lead.setNotes(request.notes());

        return leadMapper.toResponse(leadRepository.save(lead));
    }

    @Override
    public void delete(Long id) {
        Lead lead = getLeadOrThrow(id);
        if (lead.getStatus() == LeadStatus.CONVERTED) {
            throw new ConflictException("LEAD_DELETE_FORBIDDEN_CONVERTED", "Converted lead cannot be deleted");
        }
        leadRepository.delete(lead);
    }

    @Override
    public Page<LeadResponse> findByStatus(LeadStatus status, Pageable pageable) {
        return leadRepository.findByStatus(status, pageable).map(leadMapper::toResponse);
    }

    @Override
    @Transactional
    public LeadConvertResponse convert(Long id) {
        Lead lead = getLeadOrThrow(id);

        if (lead.getStatus() == LeadStatus.CONVERTED) {
            throw new ConflictException("LEAD_ALREADY_CONVERTED", "Lead is already converted");
        }

        String normalizedCompanyName = normalizeName(lead.getCompanyName());
        Company company = companyRepository.findByNameIgnoreCase(normalizedCompanyName)
                .orElseGet(() -> {
                    Company newCompany = new Company();
                    newCompany.setName(normalizedCompanyName);
                    return companyRepository.save(newCompany);
                });

        Contact contact = new Contact();
        contact.setFirstName(lead.getFirstName());
        contact.setLastName(lead.getLastName());
        contact.setEmail(lead.getEmail());
        contact.setPhone(lead.getPhone());
        contact.setCompany(company);

        try {
            contact = contactRepository.save(contact);
        } catch (DataIntegrityViolationException ex) {
            throw new ConflictException("CONTACT_EMAIL_DUPLICATE", "A contact with this email already exists");
        }

        lead.setStatus(LeadStatus.CONVERTED);
        leadRepository.save(lead);

        return new LeadConvertResponse(lead.getId(), contact.getId(), company.getId());
    }

    private Lead getLeadOrThrow(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("LEAD_NOT_FOUND", "Lead not found with id " + id));
    }

    private String normalizeName(String companyName) {
        if (companyName == null) {
            return null;
        }
        return companyName.trim();
    }
}
