package com.student.budget_advisor.advisor;

public class SafeBudgetAdvisor extends BudgetAdvisor {

    public SafeBudgetAdvisor(AdvisorRule rule) {
        super(rule);
    }

    @Override
    public String giveAdvice(double budget, double spent) {
        return rule.getAdvice(budget, spent);
    }
}