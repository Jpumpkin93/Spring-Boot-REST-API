package com.example.jungho.advice.exception;

public class CAuthenticationEntryPointException extends RuntimeException {

    public CAuthenticationEntryPointException() {
    }

    public CAuthenticationEntryPointException(String message) {
        super(message);
    }

    public CAuthenticationEntryPointException(String message, Throwable t) {
        super(message, t);
    }
}
