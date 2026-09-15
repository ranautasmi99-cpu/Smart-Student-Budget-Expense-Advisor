package com.student.budget_advisor.repository;

import com.student.budget_advisor.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}