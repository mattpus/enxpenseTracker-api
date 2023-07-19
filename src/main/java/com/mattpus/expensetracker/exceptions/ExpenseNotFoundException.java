package com.mattpus.expensetracker.exceptions;

public class ExpenseNotFoundException extends RuntimeException {

    private static final long serialVersion = 1L;

    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
