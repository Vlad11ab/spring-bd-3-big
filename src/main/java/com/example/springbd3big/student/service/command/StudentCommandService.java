package com.example.springbd3big.student.service.command;

import com.example.springbd3big.student.dtos.StudentCreateRequest;
import com.example.springbd3big.student.dtos.StudentResponse;

public interface StudentCommandService {

    StudentResponse createStudent(StudentCreateRequest req);
}
