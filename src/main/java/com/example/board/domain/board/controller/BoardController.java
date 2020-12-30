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
    public List<GetBoardResponse> viewAllBoards() {
        return boardService.viewAll();
    }

    @GetMapping("/me")
    public List<GetBoardResponse> viewMyBoards() {
        return boardService.viewMyBoards();
    }

    @GetMapping("/{boardId}")
    public GetBoardResponse viewBoardByBoardId(@PathVariable("boardId") Long boardId) {
        return boardService.viewBoardByBoardId(boardId);
    }

    @PostMapping
    public void createBoard(@Valid @RequestBody PostBoardRequest postBoardRequest) {
        boardService.createBoard(postBoardRequest);
    }

    @PutMapping("/{boardId}")
    public void modifyBoard(@PathVariable("boardId") Long boardId, @Valid @RequestBody PutBoardRequest putBoardRequest) {
        boardService.modifyBoard(boardId, putBoardRequest);
    }

    @DeleteMapping("/{boardId}")
    public void removeBoard(@PathVariable("boardId") Long boardId) {
        boardService.removeBoardByBoardId(boardId);
    }
}
