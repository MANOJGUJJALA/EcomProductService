package com.example.EcomProductService.Exception;

public class ProductNotFoundexception extends Exception{

    public ProductNotFoundexception() {
    }

    public ProductNotFoundexception(String message) {
        super(message);
    }

    public ProductNotFoundexception(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundexception(Throwable cause) {
        super(cause);
    }

    public ProductNotFoundexception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
