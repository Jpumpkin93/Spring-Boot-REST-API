package com.example.jungho.advice.exception;

public class CEmailSigninFailedException extends RuntimeException {
    public CEmailSigninFailedException() {
    }

    public CEmailSigninFailedException(String message) {
        super(message);
    }

    public CEmailSigninFailedException(String message, Throwable t) {
        super(message, t);
    }
}
