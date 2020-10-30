package com.example.board.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(400, "Bad Request(Invalid Parameter)"),
    USER_DUPLICATION(409, "User is Already Exists"),
    INVALID_LOGIN_INFO(400, "Login Information is Invalid");


    private final int status;
    private final String message;
}
