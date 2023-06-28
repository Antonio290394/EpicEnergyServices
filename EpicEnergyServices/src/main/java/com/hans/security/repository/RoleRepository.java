package com.hans.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hans.security.entity.ERole;
import com.hans.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
