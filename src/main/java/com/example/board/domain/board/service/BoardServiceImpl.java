package com.example.board.domain.board.service;

import com.example.board.domain.board.domain.entity.Board;
import com.example.board.domain.board.domain.repository.BoardRepository;
import com.example.board.domain.board.dto.GetBoardResponse;
import com.example.board.domain.board.dto.PostBoardRequest;
import com.example.board.domain.board.dto.PutBoardRequest;
import com.example.board.domain.board.exceptions.BoardNotFoundException;
import com.example.board.domain.board.exceptions.UserNotMatchedException;
import com.example.board.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void createBoard(PostBoardRequest postBoardRequest) {
        boardRepository.save(
                postBoardRequest.toEntityWithUsername(authenticationFacade.getUsername())
        );
    }

    @Override
    public List<GetBoardResponse> viewAll() {
        return boardRepository.findAll()
                .stream()
                .map(this::convertIntoGetBoardResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void modifyBoard(Long boardId, PutBoardRequest putBoardRequest) {
        Board board = boardRepository.findByBoardId(boardId)
                .orElseThrow(BoardNotFoundException::new);

        board.setTitle(putBoardRequest.getTitle());
        board.setContent(putBoardRequest.getContent());

        boardRepository.save(board);
    }

    @Override
    public GetBoardResponse viewBoardByBoardId(Long boardId) {
        return convertIntoGetBoardResponseDto(
                boardRepository.findByBoardId(boardId)
                    .orElseThrow(BoardNotFoundException::new)
        );
    }

    @Override
    public void removeBoardByBoardId(Long boardId) {
        Board board = boardRepository.findByBoardId(boardId)
                .orElseThrow(BoardNotFoundException::new);

        if (!authenticationFacade.getUsername().equals(board.getUsername())) {
            throw new UserNotMatchedException();
        }

        boardRepository.delete(board);
    }

    private GetBoardResponse convertIntoGetBoardResponseDto(Board board) {
        return GetBoardResponse.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .content(board.getContent())
                .username(board.getUsername())
                .build();
    }
}
