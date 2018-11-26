package com.example.user.ted_app_assignment_sly_v3.event;

public class ApiErrorEvent {
    private String errorMessage;

    public ApiErrorEvent(String message){
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}