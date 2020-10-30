package com.example.board.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
