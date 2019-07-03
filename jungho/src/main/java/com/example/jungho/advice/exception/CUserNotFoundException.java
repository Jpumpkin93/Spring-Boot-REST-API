package com.example.jungho.advice.exception;

public class CUserNotFoundException extends RuntimeException{

    public CUserNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public CUserNotFoundException() {
    }

    public CUserNotFoundException(String message) {
        super(message);
    }
}
