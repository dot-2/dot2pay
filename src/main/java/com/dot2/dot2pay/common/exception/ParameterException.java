package com.dot2.dot2pay.common.exception;

public class ParameterException extends GlobalException {
    private static final long serialVersionUID = 5129547206390524598L;

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Result.ErrorCode code) {
        super(message, code.getCode());
    }
}
