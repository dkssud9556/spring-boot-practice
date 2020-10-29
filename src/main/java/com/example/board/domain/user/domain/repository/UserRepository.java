package com.example.board.domain.user.domain.repository;

import com.example.board.domain.user.domain.entity.User;

public interface UserRepository {
    User findById(String username);
    void save(User user);
}
