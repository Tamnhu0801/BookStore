package com.hcmute.bookstore.repositories;

import com.hcmute.bookstore.entities.Author;
import com.hcmute.bookstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
