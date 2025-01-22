package com.ADJT.fase1.demo.repository;

import java.util.Optional;

import com.ADJT.fase1.demo.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByName(final String name);
    User findByUsername(String username);
}