package com.rabkov.multithreading.exception;

public class MultiException extends Exception{
    public MultiException() {
    }

    public MultiException(String message) {
        super(message);
    }

    public MultiException(String message, Throwable cause) {
        super(message, cause);
    }

    public MultiException(Throwable cause) {
        super(cause);
    }
}
