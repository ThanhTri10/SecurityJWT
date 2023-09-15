package com.example.SecurityJWT.repository;

import java.util.Optional;

import com.example.SecurityJWT.models.ERole;
import com.example.SecurityJWT.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}