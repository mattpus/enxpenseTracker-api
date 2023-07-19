package com.mattpus.expensetracker.service;

import com.mattpus.expensetracker.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense saveExpenseDetails(Expense expense);
    Expense findById(Long id);
    void deleteById(Long id);
    Expense updateExpenseDetails(Long id, Expense expense);
}
