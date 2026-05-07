package com.crmcastle.backend.mapper;

import com.crmcastle.backend.dto.company.CompanyResponse;
import com.crmcastle.backend.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyResponse toResponse(Company company);
}
