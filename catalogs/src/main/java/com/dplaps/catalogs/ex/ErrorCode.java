package com.dplaps.catalogs.ex;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    EmptyName(HttpStatus.BAD_REQUEST, "VAL_USER_101", "Name is mandatory"),
    EmptySurName(HttpStatus.BAD_REQUEST, "VAL_USER_102", "SurName is mandatory"),
    NoDataFound(HttpStatus.NOT_FOUND, "DB_EMPTY_101", "No Data Found");
    private HttpStatus httpStatus;
    private String code;
    private String msg;

    ErrorCode(HttpStatus httpStatus, String statusCode, String message) {
        this.httpStatus = httpStatus;
        this.code = statusCode;
        this.msg = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}