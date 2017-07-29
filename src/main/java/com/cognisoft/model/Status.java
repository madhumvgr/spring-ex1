package com.cognisoft.model;


public class Status {
    private boolean success;
    private String message;
    private int code;

    public Status() {
    }

    public Status(boolean isSuccessful, int code) {
        this.success = isSuccessful;
        this.code = code;
    }

    public Status(boolean success, String message, int code) {
		this.success = success;
		this.message = message;
		this.code = code;
	}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public int getCode() {
        return code;
    }
}
