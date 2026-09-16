package com.student.budget_advisor.controller;

import com.student.budget_advisor.entity.Expense;
import com.student.budget_advisor.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Add expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // Get expenses of a student
    @GetMapping("/student/{studentId}")
    public List<Expense> getExpensesByStudent(
            @PathVariable Long studentId) {

        return expenseService.getExpensesByStudent(studentId);
    }

    // Delete expense
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {

        expenseService.deleteExpense(id);

        return "Expense deleted successfully";
    }
}