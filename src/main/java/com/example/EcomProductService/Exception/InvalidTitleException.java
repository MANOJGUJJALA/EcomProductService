package com.example.EcomProductService.Exception;

public class InvalidTitleException extends Exception{
    public InvalidTitleException() {
    }

    public InvalidTitleException(String message) {
        super(message);
    }

    public InvalidTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTitleException(Throwable cause) {
        super(cause);
    }

    public InvalidTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
