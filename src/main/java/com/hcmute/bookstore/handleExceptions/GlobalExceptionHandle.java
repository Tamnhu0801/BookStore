package com.hcmute.bookstore.handleExceptions;

import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.exception.NotfoundException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    protected ResponseObject handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseObject.builder().status(HttpStatus.BAD_REQUEST).message(e.getMessage()).build();
    }

    @ExceptionHandler(value = {ExpiredJwtException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    protected ResponseObject handleExpiredJwtException(ExpiredJwtException e) {
        return ResponseObject.builder().status(HttpStatus.UNAUTHORIZED).message(e.getMessage()).build();
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    protected ResponseObject handleException(RuntimeException e) {
        e.printStackTrace();
        return ResponseObject.builder().status(HttpStatus.BAD_REQUEST).message(e.getMessage()).build();
    }

    @ExceptionHandler(NotfoundException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    protected ResponseObject handlerResourceNotFoundException(
            RuntimeException e) {
        return ResponseObject.builder().status(HttpStatus.NOT_FOUND).message(e.getMessage()).build();
    }
}
