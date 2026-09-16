package com.student.budget_advisor.advisor;

public abstract class BudgetAdvisor {

    protected AdvisorRule rule;

    public BudgetAdvisor(AdvisorRule rule) {
        this.rule = rule;
    }

    public abstract String giveAdvice(double budget, double spent);
}