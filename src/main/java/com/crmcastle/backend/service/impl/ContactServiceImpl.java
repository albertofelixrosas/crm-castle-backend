package com.crmcastle.backend.service.impl;

import com.crmcastle.backend.dto.contact.ContactResponse;
import com.crmcastle.backend.entity.Contact;
import com.crmcastle.backend.exception.NotFoundException;
import com.crmcastle.backend.mapper.ContactMapper;
import com.crmcastle.backend.repository.ContactRepository;
import com.crmcastle.backend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public Page<ContactResponse> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable).map(contactMapper::toResponse);
    }

    @Override
    public ContactResponse findById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CONTACT_NOT_FOUND", "Contact not found with id " + id));
        return contactMapper.toResponse(contact);
    }
}
