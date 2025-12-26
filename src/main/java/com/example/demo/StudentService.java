package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    public double calculateGPA(List<Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Grades list cannot be empty");
        }
        double sum = 0;
        for (Integer grade : grades) {
            if (grade < 0 || grade > 100) {
                throw new ArithmeticException("Grade must be between 0 and 100");
            }
            sum += grade;
        }
        return sum / grades.size();
    }

    public boolean isScholarshipEligible(double gpa) {
        // Студент получает стипендию, если средний балл выше 80
        return gpa >= 80.0;
    }

    public String getStudentStatus(double gpa) {
        if (gpa >= 90) return "Honor Roll";
        if (gpa >= 60) return "Passed";
        return "Failed";
    }
}