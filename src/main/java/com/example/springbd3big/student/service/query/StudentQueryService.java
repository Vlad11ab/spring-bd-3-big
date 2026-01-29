package com.example.springbd3big.student.service.query;

import com.example.springbd3big.student.dtos.StudentResponse;
import com.example.springbd3big.student.model.Student;

import java.util.List;

public interface StudentQueryService {

    List<StudentResponse> getAllStudents();
    StudentResponse getStudentById(Long studentId);
}
