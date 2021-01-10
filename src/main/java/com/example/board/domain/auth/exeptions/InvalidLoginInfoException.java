package com.example.board.domain.auth.exeptions;

import com.example.board.global.error.exception.BusinessException;
import com.example.board.global.error.exception.ErrorCode;

public class InvalidLoginInfoException extends BusinessException {

    public InvalidLoginInfoException() {
        super(ErrorCode.INVALID_LOGIN_INFO);
    }
}
