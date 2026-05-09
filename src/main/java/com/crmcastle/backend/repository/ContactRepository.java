package com.crmcastle.backend.repository;

import com.crmcastle.backend.entity.Company;
import com.crmcastle.backend.entity.Contact;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByEmailIgnoreCase(String email);

    boolean existsByCompany(Company company);
}
