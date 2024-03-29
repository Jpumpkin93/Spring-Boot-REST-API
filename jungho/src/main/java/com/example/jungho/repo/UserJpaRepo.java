package com.example.jungho.repo;

import com.example.jungho.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUid(String email);
}
