package com.projects.EmployeeData.exception;

import com.projects.EmployeeData.entity.Employee;

public class SuccessMessage<T>{
    private boolean success;
    private int statusCode;
    private String message;
    private T data;

    public SuccessMessage(boolean success, int statusCode, String message, T data) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
