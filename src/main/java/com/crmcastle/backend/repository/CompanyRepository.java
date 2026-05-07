package com.crmcastle.backend.repository;

import com.crmcastle.backend.entity.Company;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByNameIgnoreCase(String name);
}
