package com.example.board.domain.auth.service;

import com.example.board.domain.auth.dto.SignInRequest;
import com.example.board.domain.auth.dto.SignInResponse;
import com.example.board.domain.auth.dto.SignUpRequest;

public interface AuthService {
    void signUp(SignUpRequest signUpRequest);
    SignInResponse signIn(SignInRequest signInRequest);
}
