package com.example.board.global.error.exception;

public class InvalidTokenException extends BusinessException {
    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
