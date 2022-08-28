package com.vmanmedia.books.securities.repositories;

import com.vmanmedia.books.securities.entity.Role;
import com.vmanmedia.books.securities.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
