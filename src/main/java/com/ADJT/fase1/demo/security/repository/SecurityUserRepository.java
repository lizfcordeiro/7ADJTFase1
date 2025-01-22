package com.ADJT.fase1.demo.security.repository;

import java.util.Optional;

import com.ADJT.fase1.demo.security.entity.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityUserRepository  extends JpaRepository<SecurityUser, Long>{
    Optional<SecurityUser> findByUsername(final String name);
    boolean existsSecurityUserByUsername(final String username);
}