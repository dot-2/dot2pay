package com.dot2.exception;

public class ForbiddenException extends GlobalException {
    public ForbiddenException(String message, Result.ErrorCode code) {
        super(message, code.getCode());
    }

    public ForbiddenException(String message) {
        super(message, Result.ErrorCode.Forbidden.getCode());
    }

    public ForbiddenException() {
        super("无权限", Result.ErrorCode.Forbidden.getCode());
    }

}