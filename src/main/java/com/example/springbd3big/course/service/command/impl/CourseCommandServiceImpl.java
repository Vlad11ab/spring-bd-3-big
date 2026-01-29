package com.example.springbd3big.course.service.command.impl;

import com.example.springbd3big.course.dtos.CourseCreateRequest;
import com.example.springbd3big.course.dtos.CourseResponse;
import com.example.springbd3big.course.dtos.CourseUpdateRequest;
import com.example.springbd3big.course.service.command.CourseCommandService;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandServiceImpl implements CourseCommandService {
    @Override
    public CourseResponse createCourse(CourseCreateRequest req) {
return null;
    }

    @Override
    public CourseResponse updateCourse(Long courseId, CourseUpdateRequest req) {
        return null;
    }

    @Override
    public CourseResponse deleteCourse(Long courseId) {
        return null;
    }
}
