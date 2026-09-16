package com.student.budget_advisor.advisor;

public class SimpleAdvisorRule implements AdvisorRule {

    @Override
    public String getAdvice(double budget, double spent) {

        if (spent > budget) {
            return "You have exceeded your budget.";
        } else if (spent >= budget * 0.8) {
            return "Warning: You have used most of your budget.";
        } else {
            return "Good job! Your spending is under control.";
        }
    }
}