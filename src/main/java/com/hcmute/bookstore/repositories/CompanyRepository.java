package com.hcmute.bookstore.repositories;

import com.hcmute.bookstore.entities.Author;
import com.hcmute.bookstore.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);
}
