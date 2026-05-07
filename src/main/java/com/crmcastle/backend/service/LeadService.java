package com.crmcastle.backend.service;

import com.crmcastle.backend.dto.lead.LeadConvertResponse;
import com.crmcastle.backend.dto.lead.LeadCreateRequest;
import com.crmcastle.backend.dto.lead.LeadResponse;
import com.crmcastle.backend.dto.lead.LeadUpdateRequest;
import com.crmcastle.backend.entity.LeadStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LeadService {
    LeadResponse create(LeadCreateRequest request);

    Page<LeadResponse> findAll(Pageable pageable);

    LeadResponse findById(Long id);

    LeadResponse update(Long id, LeadUpdateRequest request);

    void delete(Long id);

    Page<LeadResponse> findByStatus(LeadStatus status, Pageable pageable);

    LeadConvertResponse convert(Long id);
}
