package com.example.board.domain.board.dto;

import com.example.board.domain.board.domain.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PutBoardRequest {
    private String title;
    private String content;
}
