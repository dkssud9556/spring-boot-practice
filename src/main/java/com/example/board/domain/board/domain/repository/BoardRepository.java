package com.example.board.domain.board.domain.repository;

import com.example.board.domain.board.domain.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    List<Board> findAll();
    Board save(Board board);
    Optional<Board> findByBoardId(Long boardId);
}
