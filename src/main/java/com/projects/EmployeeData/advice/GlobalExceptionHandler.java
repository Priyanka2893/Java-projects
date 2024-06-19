package com.projects.EmployeeData.advice;
import com.projects.EmployeeData.exception.EmployeeBadRequestException;
import com.projects.EmployeeData.exception.EmployeeNotfoundException;
import com.projects.EmployeeData.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotfoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(EmployeeNotfoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                false);
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeBadRequestException.class)
    public ResponseEntity<ErrorMessage> badRequestException(EmployeeBadRequestException ex){
        ErrorMessage message = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                false);
        return new ResponseEntity<ErrorMessage>(message,HttpStatus.BAD_REQUEST);
    }
}
