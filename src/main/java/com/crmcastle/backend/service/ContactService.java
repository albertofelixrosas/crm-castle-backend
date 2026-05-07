package com.crmcastle.backend.service;

import com.crmcastle.backend.dto.contact.ContactResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    Page<ContactResponse> findAll(Pageable pageable);

    ContactResponse findById(Long id);
}
