package com.example.board.domain.auth.exeptions;

import com.example.board.global.error.exception.BusinessException;
import com.example.board.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends BusinessException {

    public UserAlreadyExistsException() {
        super(ErrorCode.USER_DUPLICATION);
    }
}
