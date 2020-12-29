package com.example.board.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PutBoardRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
