package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.reponses;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private Map<String, List<String>>  fieldErrors = Collections.emptyMap();

    public ErrorResponse(){}

    public ErrorResponse(String message, int status){
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
    public ErrorResponse(String message, int status, Map<String, List<String>> fieldErrors){
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.fieldErrors = fieldErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, List<String>> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, List<String>> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }


}