package com.bergony.demo.rest;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;


    public StudentErrorResponse() {
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
