package com.example.board.domain.board.service;

import com.example.board.domain.board.dto.GetBoardResponse;
import com.example.board.domain.board.dto.PostBoardRequest;
import com.example.board.domain.board.dto.PutBoardRequest;

import java.util.List;

public interface BoardService {
    void createBoard(PostBoardRequest postBoardRequest);
    List<GetBoardResponse> viewAll();
    List<GetBoardResponse> viewMyBoards();
    GetBoardResponse viewBoardByBoardId(Long boardId);
    void modifyBoard(Long boardId, PutBoardRequest putBoardRequest);
    void removeBoardByBoardId(Long boardId);
}
