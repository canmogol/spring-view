package com.fererlab.core.model;


public class AlertMessage implements Model{

    private final String message;

    public AlertMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
