package com.crmcastle.backend.mapper;

import com.crmcastle.backend.dto.company.CompanyCreateRequest;
import com.crmcastle.backend.dto.company.CompanyResponse;
import com.crmcastle.backend.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Company toEntity(CompanyCreateRequest request);

    CompanyResponse toResponse(Company company);
}
