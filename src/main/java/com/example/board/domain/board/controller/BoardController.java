package com.example.board.domain.board.controller;

import com.example.board.domain.board.domain.entity.Board;
import com.example.board.domain.board.domain.repository.BoardRepository;
import com.example.board.domain.board.dto.PostBoardRequest;
import com.example.board.domain.board.dto.PutBoardRequest;
import com.example.board.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAll();
    }

    @PostMapping
    public void postBoard(@RequestBody PostBoardRequest postBoardRequest) {
        boardService.postBoard(postBoardRequest);
    }

    @PutMapping("/{boardId}")
    public void putBoard(@PathVariable("boardId") Long boardId, @RequestBody PutBoardRequest putBoardRequest) {
        boardService.modifyBoard(boardId, putBoardRequest);
    }
}
