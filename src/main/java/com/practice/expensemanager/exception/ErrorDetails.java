package com.practice.expensemanager.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private int errorCode;
    private String message;
    private String path;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ErrorDetails(Date timestamp, int errorCode, String message, String path) {
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
        this.path = path;
    }
}
