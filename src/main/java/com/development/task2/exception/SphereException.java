package com.development.task2.exception;

public class SphereException extends Exception {

    public SphereException() {
        super();
    }

    public SphereException(String message) {
        super(message);
    }

    public SphereException(String message, Throwable cause) {
        super(message, cause);
    }

    public SphereException(Throwable cause) {
        super(cause);
    }

}
