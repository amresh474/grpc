package com.dplaps.catalogs.ex;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private HttpStatus httpStatus;

    public ValidationException(ErrorCode errorCode) {
        super(errorCode.getCode());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.httpStatus = errorCode.getHttpStatus();
    }
}