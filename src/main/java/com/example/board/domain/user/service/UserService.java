package com.example.board.domain.user.service;

import com.example.board.domain.user.dto.SignUpRequest;

public interface UserService {
    void signUp(SignUpRequest signUpRequest);
}
