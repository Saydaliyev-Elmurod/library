package com.example.library.exp;

public class AppBadRequestException extends RuntimeException{
    public AppBadRequestException() {
        super();
    }

    public AppBadRequestException(String message) {
        super(message);
    }
}
