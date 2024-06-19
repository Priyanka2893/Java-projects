package com.projects.EmployeeData.exception;

public class EmployeeBadRequestException extends RuntimeException{
    public EmployeeBadRequestException(String msg){
        super(msg);
    }
}
