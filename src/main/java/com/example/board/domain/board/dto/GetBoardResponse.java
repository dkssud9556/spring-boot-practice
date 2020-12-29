package com.example.board.domain.board.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class GetBoardResponse {
    @JsonProperty("board_id")
    private Long boardId;
    private String title;
    private String content;
    private String username;
}
