package com.example.springbd3big.course.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long courseId) {
        super("COURSE_NOT_FOUND_EXCEPTION");
    }
}
