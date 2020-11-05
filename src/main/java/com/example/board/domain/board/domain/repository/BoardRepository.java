package com.example.board.domain.board.domain.repository;

import com.example.board.domain.board.domain.entity.Board;

import java.util.List;

public interface BoardRepository {
    List<Board> findAll();
    Board save(Board board);
}
