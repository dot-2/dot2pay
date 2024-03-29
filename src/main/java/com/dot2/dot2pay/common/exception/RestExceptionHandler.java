package com.dot2.dot2pay.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class RestExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleResourceNotFoundException(NotFoundException e) {
        logger.info(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleResourceUnauthorizedException(UnauthorizedException e) {
        logger.info(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(value = ForbiddenException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleResourceForbiddenException(ForbiddenException e) {
        logger.info(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(value = ParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Object handleResourceErrException(ParameterException e) {
        logger.info(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());

    }
}