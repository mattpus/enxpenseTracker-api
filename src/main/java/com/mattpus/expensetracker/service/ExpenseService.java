package com.mattpus.expensetracker.service;

import com.mattpus.expensetracker.expenses.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
}
