package com.crmcastle.backend.controller;

import com.crmcastle.backend.dto.lead.LeadConvertResponse;
import com.crmcastle.backend.dto.lead.LeadCreateRequest;
import com.crmcastle.backend.dto.lead.LeadResponse;
import com.crmcastle.backend.dto.lead.LeadUpdateRequest;
import com.crmcastle.backend.entity.LeadStatus;
import com.crmcastle.backend.service.LeadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

    @PostMapping
    public ResponseEntity<LeadResponse> create(@Valid @RequestBody LeadCreateRequest request) {
        LeadResponse response = leadService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<LeadResponse>> findAll(
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return ResponseEntity.ok(leadService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeadResponse> update(@PathVariable Long id, @Valid @RequestBody LeadUpdateRequest request) {
        return ResponseEntity.ok(leadService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        leadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<LeadResponse>> findByStatus(
            @PathVariable LeadStatus status,
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return ResponseEntity.ok(leadService.findByStatus(status, pageable));
    }

    @PostMapping("/{id}/convert")
    public ResponseEntity<LeadConvertResponse> convert(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.convert(id));
    }
}
