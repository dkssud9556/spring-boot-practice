package com.example.board.domain.auth.domain.repository;

import com.example.board.domain.auth.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    User save(User user);
}
