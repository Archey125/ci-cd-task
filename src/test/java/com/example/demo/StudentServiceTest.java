package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private final StudentService service = new StudentService();

    @Test
    void testCalculateGPA_Normal() {
        List<Integer> grades = Arrays.asList(90, 80, 100);
        assertEquals(90.0, service.calculateGPA(grades), "Average of 90, 80, 100 should be 90");
    }

    @Test
    void testCalculateGPA_Empty() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateGPA(Collections.emptyList()));
    }

    @Test
    void testInvalidGrade() {
        assertThrows(ArithmeticException.class, () -> service.calculateGPA(Arrays.asList(150)));
    }

    @Test
    void testScholarshipEligibility() {
        assertTrue(service.isScholarshipEligible(80.0));
        assertTrue(service.isScholarshipEligible(95.5));
        assertFalse(service.isScholarshipEligible(79.9));
    }

    @Test
    void testStudentStatus() {
        assertEquals("Honor Roll", service.getStudentStatus(91));
        assertEquals("Passed", service.getStudentStatus(75));
        assertEquals("Failed", service.getStudentStatus(40));
    }
}