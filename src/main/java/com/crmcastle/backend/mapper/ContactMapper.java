package com.crmcastle.backend.mapper;

import com.crmcastle.backend.dto.contact.ContactResponse;
import com.crmcastle.backend.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "companyName", source = "company.name")
    ContactResponse toResponse(Contact contact);
}
