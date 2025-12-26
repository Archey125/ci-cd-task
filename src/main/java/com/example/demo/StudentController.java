package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/analyze")
    public String analyzeStudent(@RequestParam String name, @RequestParam List<Integer> grades) {
        double gpa = studentService.calculateGPA(grades);
        boolean eligible = studentService.isScholarshipEligible(gpa);
        String status = studentService.getStudentStatus(gpa);

        return String.format("Student: %s | GPA: %.2f | Status: %s | Scholarship: %b",
                name, gpa, status, eligible);
    }

    @GetMapping("/")
    public String healthCheck() {
        return "Student System is Active!";
    }
}