package com.example.board.domain.auth.controller;

import com.example.board.domain.auth.dto.SignInRequest;
import com.example.board.domain.auth.dto.SignInResponse;
import com.example.board.domain.auth.dto.SignUpRequest;
import com.example.board.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public void signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);
    }

    @PostMapping("/signin")
    public SignInResponse signIn(@Valid @RequestBody SignInRequest signInRequest) {
        return authService.signIn(signInRequest);
    }
}
