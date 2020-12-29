package com.example.board.domain.user.controller;

import com.example.board.domain.user.dto.SignInRequest;
import com.example.board.domain.user.dto.SignInResponse;
import com.example.board.domain.user.dto.SignUpRequest;
import com.example.board.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public void signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest);
    }

    @PostMapping("/signin")
    public SignInResponse signIn(@Valid @RequestBody SignInRequest signInRequest) {
        return userService.signIn(signInRequest);
    }
}
