package com.example.board.domain.board.service;

import com.example.board.domain.board.domain.entity.Board;
import com.example.board.domain.board.domain.repository.BoardRepository;
import com.example.board.domain.board.dto.PostBoardRequest;
import com.example.board.domain.board.dto.PutBoardRequest;
import com.example.board.domain.board.exceptions.BoardNotFoundException;
import com.example.board.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void postBoard(PostBoardRequest postBoardRequest) {
        boardRepository.save(
                postBoardRequest.toEntityWithUsername(authenticationFacade.getUsername())
        );
    }

    @Override
    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    @Override
    public void modifyBoard(Long boardId, PutBoardRequest putBoardRequest) {
        Board board = boardRepository.findByBoardId(boardId)
                .orElseThrow(BoardNotFoundException::new);

        board.setTitle(putBoardRequest.getTitle());
        board.setContent(putBoardRequest.getContent());

        boardRepository.save(board);
    }
}
