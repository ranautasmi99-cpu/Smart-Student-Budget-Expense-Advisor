package com.student.budget_advisor.repository;

import com.student.budget_advisor.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByStudentId(Long studentId);
}