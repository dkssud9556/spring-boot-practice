package com.example.board.domain.board.service;

import com.example.board.domain.board.domain.entity.Board;
import com.example.board.domain.board.domain.repository.BoardRepository;
import com.example.board.domain.board.dto.PostBoardRequest;
import com.example.board.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void postBoard(PostBoardRequest postBoardRequest) {
        boardRepository.save(Board.builder()
                .content(postBoardRequest.getContent())
                .title(postBoardRequest.getTitle())
                .username(authenticationFacade.getUsername())
                .build());
    }
}
