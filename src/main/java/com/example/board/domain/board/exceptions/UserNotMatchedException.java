package com.example.board.domain.board.exceptions;

import com.example.board.global.error.exception.BusinessException;
import com.example.board.global.error.exception.ErrorCode;

public class UserNotMatchedException extends BusinessException {

    public UserNotMatchedException() {
        super(ErrorCode.USER_NOT_MATCHED);
    }
}
