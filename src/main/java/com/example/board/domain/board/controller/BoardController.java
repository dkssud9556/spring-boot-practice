package com.example.board.domain.board.controller;

import com.example.board.domain.board.dto.GetBoardResponse;
import com.example.board.domain.board.dto.PostBoardRequest;
import com.example.board.domain.board.dto.PutBoardRequest;
import com.example.board.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<GetBoardResponse> getAllBoards() {
        return boardService.getAll();
    }

    @PostMapping
    public void postBoard(@Valid @RequestBody PostBoardRequest postBoardRequest) {
        boardService.postBoard(postBoardRequest);
    }

    @PutMapping("/{boardId}")
    public void putBoard(@PathVariable("boardId") Long boardId, @Valid @RequestBody PutBoardRequest putBoardRequest) {
        boardService.modifyBoard(boardId, putBoardRequest);
    }
}
