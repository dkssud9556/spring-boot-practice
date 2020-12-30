package com.example.board.domain.board.infra;

import com.example.board.domain.board.domain.entity.Board;
import com.example.board.domain.board.domain.repository.BoardRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaBoardRepository extends JpaRepository<Board, Long>, BoardRepository {
    @Override
    List<Board> findAll();

    @Override
    Board save(Board board);

    @Override
    Optional<Board> findByBoardId(Long boardId);

    @Override
    void delete(Board board);

    @Override
    List<Board> findAllByUsername(String username);
}
