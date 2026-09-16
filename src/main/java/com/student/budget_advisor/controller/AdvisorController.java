package com.student.budget_advisor.controller;

import com.student.budget_advisor.advisor.AdvisorRule;
import com.student.budget_advisor.advisor.BudgetAdvisor;
import com.student.budget_advisor.advisor.SafeBudgetAdvisor;
import com.student.budget_advisor.advisor.SimpleAdvisorRule;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advisor")
public class AdvisorController {

    @GetMapping
    public String getAdvice(
            @RequestParam double budget,
            @RequestParam double spent) {

        AdvisorRule rule = new SimpleAdvisorRule();

        BudgetAdvisor advisor = new SafeBudgetAdvisor(rule);

        return advisor.giveAdvice(budget, spent);
    }
}