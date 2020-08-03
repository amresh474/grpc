package com.dplaps.catalogs.ex;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorRes {
    private String msg;
    private String cause;
    private boolean status;
    private String code;

    public ErrorRes(String msg, String cause, String code) {
        this.msg = msg;
        this.cause = cause;
        this.status = false;
        this.code = code;
    }
}