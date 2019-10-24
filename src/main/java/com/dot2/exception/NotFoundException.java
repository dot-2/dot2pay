package com.dot2.exception;

public class NotFoundException extends GlobalException
{
    private static final long serialVersionUID = -4615448951392606669L;

    public NotFoundException(String message, Result.ErrorCode code)
    {
        super(message, code.getCode());
    }
}