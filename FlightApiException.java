package com.FlightAPI.exception;

import org.springframework.http.HttpStatus;

public class FlightApiException extends RuntimeException {

    private HttpStatus status;
    private String message ;

    public FlightApiException(HttpStatus status, String message) {

        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
