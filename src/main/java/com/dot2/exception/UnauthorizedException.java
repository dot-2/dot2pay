package com.dot2.exception;

public class UnauthorizedException extends GlobalException{
    public UnauthorizedException(String message, Result.ErrorCode code) {
        super(message, code.getCode());
    }

    public UnauthorizedException(String message) {
        super(message, Result.ErrorCode.Unauthorized.getCode());
    }
    public UnauthorizedException() {
        super("未登录", Result.ErrorCode.Unauthorized.getCode());
    }
}
