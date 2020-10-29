package com.example.board.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotNull
    private int age;
}
