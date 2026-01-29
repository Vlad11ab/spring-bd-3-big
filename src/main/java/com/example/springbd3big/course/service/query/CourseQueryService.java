package com.example.springbd3big.course.service.query;

import com.example.springbd3big.course.dtos.CourseResponse;

import java.util.List;

public interface CourseQueryService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourseById(Long courseId);
}
