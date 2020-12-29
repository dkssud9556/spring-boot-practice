package com.example.board.domain.board.service;

import com.example.board.domain.board.domain.entity.Board;
import com.example.board.domain.board.dto.PostBoardRequest;
import com.example.board.domain.board.dto.PutBoardRequest;

import java.util.List;

public interface BoardService {
    void postBoard(PostBoardRequest postBoardRequest);
    List<Board> getAll();
    void modifyBoard(Long boardId, PutBoardRequest putBoardRequest);
}
