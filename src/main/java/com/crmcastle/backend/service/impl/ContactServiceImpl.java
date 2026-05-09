package com.crmcastle.backend.service.impl;

import com.crmcastle.backend.dto.contact.ContactCreateRequest;
import com.crmcastle.backend.dto.contact.ContactResponse;
import com.crmcastle.backend.dto.contact.ContactUpdateRequest;
import com.crmcastle.backend.entity.Company;
import com.crmcastle.backend.entity.Contact;
import com.crmcastle.backend.exception.ConflictException;
import com.crmcastle.backend.exception.NotFoundException;
import com.crmcastle.backend.mapper.ContactMapper;
import com.crmcastle.backend.repository.CompanyRepository;
import com.crmcastle.backend.repository.ContactRepository;
import com.crmcastle.backend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final ContactMapper contactMapper;

    @Override
    public Page<ContactResponse> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable).map(contactMapper::toResponse);
    }

    @Override
    public ContactResponse findById(Long id) {
        return contactMapper.toResponse(getOrThrow(id));
    }

    @Override
    public ContactResponse create(ContactCreateRequest request) {
        Company company = getCompanyOrThrow(request.companyId());
        Contact contact = contactMapper.toEntity(
                request.firstName(), request.lastName(),
                request.email(), request.phone(), company);
        try {
            return contactMapper.toResponse(contactRepository.save(contact));
        } catch (DataIntegrityViolationException ex) {
            throw new ConflictException("CONTACT_EMAIL_DUPLICATE", "A contact with this email already exists");
        }
    }

    @Override
    public ContactResponse update(Long id, ContactUpdateRequest request) {
        Contact contact = getOrThrow(id);
        Company company = getCompanyOrThrow(request.companyId());
        contact.setFirstName(request.firstName());
        contact.setLastName(request.lastName());
        contact.setEmail(request.email());
        contact.setPhone(request.phone());
        contact.setCompany(company);
        try {
            return contactMapper.toResponse(contactRepository.save(contact));
        } catch (DataIntegrityViolationException ex) {
            throw new ConflictException("CONTACT_EMAIL_DUPLICATE", "A contact with this email already exists");
        }
    }

    @Override
    public void delete(Long id) {
        contactRepository.delete(getOrThrow(id));
    }

    private Contact getOrThrow(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CONTACT_NOT_FOUND", "Contact not found with id " + id));
    }

    private Company getCompanyOrThrow(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new NotFoundException("COMPANY_NOT_FOUND", "Company not found with id " + companyId));
    }
}
