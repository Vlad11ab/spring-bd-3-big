package com.example.springbd3big.course.service.query.impl;

import com.example.springbd3big.course.dtos.CourseResponse;
import com.example.springbd3big.course.repository.CourseRepository;
import com.example.springbd3big.course.service.query.CourseQueryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseQueryServiceImpl implements CourseQueryService {

    private CourseRepository courseRepository;

    public CourseQueryServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;

    }
    @Override
    public List<CourseResponse> getAllCourses() {

        return List.of();
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        return null;
    }
}
