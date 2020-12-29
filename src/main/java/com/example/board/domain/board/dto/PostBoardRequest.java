package com.example.board.domain.board.dto;

import com.example.board.domain.board.domain.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostBoardRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Board toEntityWithUsername(String username) {
        return Board.builder()
                .username(username)
                .title(title)
                .content(content)
                .build();
    }
}
