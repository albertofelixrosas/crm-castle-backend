package com.crmcastle.backend.mapper;

import com.crmcastle.backend.dto.lead.LeadCreateRequest;
import com.crmcastle.backend.dto.lead.LeadResponse;
import com.crmcastle.backend.entity.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeadMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", expression = "java(com.crmcastle.backend.entity.LeadStatus.NEW)")
    @Mapping(target = "createdAt", ignore = true)
    Lead toEntity(LeadCreateRequest request);

    LeadResponse toResponse(Lead lead);
}
