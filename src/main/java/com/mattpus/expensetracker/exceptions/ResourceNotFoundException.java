package com.mattpus.expensetracker.exceptions;

public class ResourceNotFoundException  extends RuntimeException {

    private static final long serialVersion = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
