package com.dplaps.catalogs.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ValidationException.class})
    public final ResponseEntity<ErrorRes> handleValidationException(ValidationException ex, WebRequest request) {
        ErrorRes errorRes = new ErrorRes(ex.getMsg(), "Validation Error", ex.getCode());
        return new ResponseEntity<>(errorRes, ex.getHttpStatus());
    }

    @ExceptionHandler({NotFoundException.class})
    public final ResponseEntity<ErrorRes> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorRes errorRes = new ErrorRes(ex.getMsg(), "No data Found", ex.getCode());
        return new ResponseEntity<>(errorRes, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorRes> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorRes errorRes = new ErrorRes(ex.getMessage(), ex.getMessage(), "500");
        return new ResponseEntity<>(errorRes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}