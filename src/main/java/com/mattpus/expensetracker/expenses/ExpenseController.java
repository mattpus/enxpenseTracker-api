package com.mattpus.expensetracker.expenses;

import com.mattpus.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    private ExpenseService expenseService;

    @RequestMapping("expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();

    }
}
