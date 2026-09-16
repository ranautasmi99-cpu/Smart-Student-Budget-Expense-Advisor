package com.student.budget_advisor.advisor;

public interface AdvisorRule {

    String getAdvice(double budget, double spent);
}
