package com.hcmute.bookstore.repositories;

import com.hcmute.bookstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    @Query("SELECT c3 FROM Category c1 JOIN c1.children c2 JOIN c2.children c3")
    List<Category> findAllLevel3();
}
