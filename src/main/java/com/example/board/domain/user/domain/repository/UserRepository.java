package com.example.board.domain.user.domain.repository;

import com.example.board.domain.user.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String username);
    void save(User user);
}
