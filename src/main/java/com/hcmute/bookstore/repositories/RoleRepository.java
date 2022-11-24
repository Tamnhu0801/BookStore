package com.hcmute.bookstore.repositories;

import com.hcmute.bookstore.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findOneById(Integer id);
}
