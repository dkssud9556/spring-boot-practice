package com.example.board.domain.user.domain.repository;

import com.example.board.domain.user.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    User save(User user);
}
