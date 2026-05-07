package com.crmcastle.backend.controller;

import com.crmcastle.backend.dto.contact.ContactResponse;
import com.crmcastle.backend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<Page<ContactResponse>> findAll(
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return ResponseEntity.ok(contactService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.findById(id));
    }
}
