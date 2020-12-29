package com.example.board.domain.board.exceptions;

import com.example.board.global.error.exception.BusinessException;
import com.example.board.global.error.exception.ErrorCode;

public class BoardNotFoundException extends BusinessException {

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
