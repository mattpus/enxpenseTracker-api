package com.mattpus.expensetracker.controller;

import com.mattpus.expensetracker.model.Expense;
import com.mattpus.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ExpenseController {

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    private ExpenseService expenseService;

    @GetMapping("expenses")
    public List<Expense> getAllExpenses(Pageable page) {
        return expenseService.getAllExpenses(page).toList();

    }

    @GetMapping("expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.findById(id);
    }

    @ResponseStatus(value =  HttpStatus.NO_CONTENT)
    @DeleteMapping("expenses")
    public void deleteExpenseById(@RequestParam Long id) {
        expenseService.deleteById(id);
    }

    @ResponseStatus(value =  HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
        return expenseService.updateExpenseDetails(id, expense);
    }

    @GetMapping("expenses/category")
    public List<Expense> getExpenseByCategory(@RequestParam String category, Pageable page) {
        return expenseService.readByCategory(category, page);
    }

    @GetMapping("expenses/name")
    public List<Expense> getExpenseByName(@RequestParam String keyword, Pageable page) {
        return expenseService.readByName(keyword, page);
    }

    @GetMapping("expenses/date")
    public List<Expense> getExpenseByDateBetween(@RequestParam(required = false) Date startDate,
                                                 @RequestParam(required = false) Date endDate,
                                                 Pageable page) {
        return expenseService.readByDate(startDate, endDate, page);
    }
}
