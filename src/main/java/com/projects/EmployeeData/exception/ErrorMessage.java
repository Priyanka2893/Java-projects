package com.projects.EmployeeData.exception;

public class ErrorMessage{
    private String message;
    private int status;
    private boolean success;

    public ErrorMessage(String message, int status, boolean success) {
        this.message = message;
        this.status = status;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return success;
    }
}


//Map<String, Object> map = new HashMap<String, Object>();
//        map.put("message", message);
//        map.put("status", status.value());
//        map.put("data", responseObj);
//boolean success = status.is2xxSuccessful();
//        map.put("success", success);
//
//        return new ResponseEntity<Object>(map, status);