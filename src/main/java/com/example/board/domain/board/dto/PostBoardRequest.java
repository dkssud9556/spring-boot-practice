package com.example.board.domain.board.dto;

import com.example.board.domain.board.domain.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostBoardRequest {
    private String title;
    private String content;

    public Board toEntityWithUsername(String username) {
        return Board.builder()
                .username(username)
                .title(title)
                .content(content)
                .build();
    }
}
