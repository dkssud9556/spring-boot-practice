package com.example.board.domain.user.domain;

public interface TokenProvider {
    String generateToken(String username);
}
