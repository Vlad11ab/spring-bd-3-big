package com.example.springbd3big.student.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long studentId) {
        super("STUDENT_NOT_FOUND_EXCEPTION");
    }
}
