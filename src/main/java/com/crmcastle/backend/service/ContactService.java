package com.crmcastle.backend.service;

import com.crmcastle.backend.dto.contact.ContactCreateRequest;
import com.crmcastle.backend.dto.contact.ContactResponse;
import com.crmcastle.backend.dto.contact.ContactUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    Page<ContactResponse> findAll(Pageable pageable);

    ContactResponse findById(Long id);

    ContactResponse create(ContactCreateRequest request);

    ContactResponse update(Long id, ContactUpdateRequest request);

    void delete(Long id);
}
