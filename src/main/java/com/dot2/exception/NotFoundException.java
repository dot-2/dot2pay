package com.dot2.exception;

public class NotFoundException extends GlobalException
{
    public NotFoundException(String message, Result.ErrorCode code)
    {
        super(message, code.getCode());
    }
}