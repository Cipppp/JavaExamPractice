package com.example.examen.exceptions;

public class EmptySpecialtyFilterException extends Exception{
    public EmptySpecialtyFilterException() {
    }

    public EmptySpecialtyFilterException(String message) {
        super(message);
    }

    public EmptySpecialtyFilterException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptySpecialtyFilterException(Throwable cause) {
        super(cause);
    }

    public EmptySpecialtyFilterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
