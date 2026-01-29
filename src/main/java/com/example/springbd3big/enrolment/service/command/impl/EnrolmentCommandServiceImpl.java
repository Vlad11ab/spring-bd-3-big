package com.example.springbd3big.enrolment.service.command.impl;

import com.example.springbd3big.course.exceptions.CourseNotFoundException;
import com.example.springbd3big.course.model.Course;
import com.example.springbd3big.course.repository.CourseRepository;
import com.example.springbd3big.enrolment.dtos.EnrolmentCreateRequest;
import com.example.springbd3big.enrolment.dtos.EnrolmentResponse;
import com.example.springbd3big.enrolment.mappers.EnrolmentMapper;
import com.example.springbd3big.enrolment.model.Enrolment;
import com.example.springbd3big.enrolment.repository.EnrolmentRepository;
import com.example.springbd3big.enrolment.service.command.EnrolmentCommandService;
import com.example.springbd3big.student.exceptions.StudentNotFoundException;
import com.example.springbd3big.student.model.Student;
import com.example.springbd3big.student.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class EnrolmentCommandServiceImpl implements EnrolmentCommandService {

    private EnrolmentRepository enrolmentRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private EnrolmentMapper enrolmentMapper;

    public EnrolmentCommandServiceImpl(
            EnrolmentRepository enrolmentRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            EnrolmentMapper enrolmentMapper
    ){
        this.enrolmentRepository = enrolmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrolmentMapper = enrolmentMapper;

    }


    @Override
    @Transactional
    public EnrolmentResponse enrollStudent(EnrolmentCreateRequest req) {
        Course course = courseRepository.findById(req.courseId())
                .orElseThrow(()-> new CourseNotFoundException(req.courseId()));
        Student student  = studentRepository.findById(req.studentId())
                .orElseThrow(()-> new StudentNotFoundException(req.studentId()));
        Enrolment enrolment = Enrolment.builder()
                .student(student)
                .course(course)
                .build();
        enrolmentRepository.save(enrolment);
        return enrolmentMapper.toDto(enrolment);
    }
}
