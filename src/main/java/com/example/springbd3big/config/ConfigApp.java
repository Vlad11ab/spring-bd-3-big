package com.example.springbd3big.config;

import com.example.springbd3big.course.repository.CourseRepository;
import com.example.springbd3big.enrolment.dtos.EnrolmentCreateRequest;
import com.example.springbd3big.enrolment.service.command.EnrolmentCommandService;
import com.example.springbd3big.student.dtos.StudentCreateRequest;
import com.example.springbd3big.student.dtos.StudentResponse;
import com.example.springbd3big.student.dtos.StudentUpdateRequest;
import com.example.springbd3big.student.repository.StudentRepository;
import com.example.springbd3big.student.service.command.StudentCommandService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ConfigApp {

    private EnrolmentCommandService enrolmentCommandService;
    private StudentCommandService studentCommandService;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public ConfigApp(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            EnrolmentCommandService enrolmentCommandService,
            StudentCommandService studentCommandService
    ){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrolmentCommandService = enrolmentCommandService;
        this.studentCommandService = studentCommandService;


//        this.testFindAllStudents();
//        this.testFindStudentById();
        this.testFindAllCourses();
//        this.testStudentExistsByEmailJPQL();
//        this.testEnrollStudent();
//        this.testCreateStudent();
//        this.testUpdateStudent();
//        this.testRemoveStudent();
    }

    public void testFindAllStudents(){
        studentRepository.findAll().forEach(System.out::println);
    }

    public void testFindStudentById(){
        System.out.println(studentRepository.findById(1L));
    }

    public void testFindAllCourses(){
        courseRepository.findAll().forEach(System.out::println);
    }

    public void testStudentExistsByEmailJPQL(){
        if(studentRepository.existsByEmailJPQL("maria.ionesc@email.com")){
            System.out.println("Exista");
        } else System.out.println("Nu exista");

    }

    public void testEnrollStudent(){
        EnrolmentCreateRequest testReq = EnrolmentCreateRequest.builder()
                .studentId(5L)
                .courseId(5L)
                .build();
        System.out.println("Enrolment salvat");
        enrolmentCommandService.enrollStudent(testReq);
    }

    public void testCreateStudent(){
        StudentCreateRequest createReq = new StudentCreateRequest(
                "createdFirstname",
                "createdLastName",
                "createdEmail@create.com");

        StudentResponse created = studentCommandService.createStudent(createReq);
        System.out.printf("Studentul " + created + " a fost creat");

    }

    public void testUpdateStudent(){
        StudentUpdateRequest updateReq = new StudentUpdateRequest(
                "Vali",
                "Marin",
                "email");

        StudentResponse updated = studentCommandService.updateStudent(52L, updateReq);
        System.out.println("Studentul " + updated + " a fost updatat");
    }

    public void testRemoveStudent(){
        studentCommandService.deleteStudent(102L);

    }




}
