package com.example.springbd3big.config;

import com.example.springbd3big.enrolment.dtos.EnrolmentCreateRequest;
import com.example.springbd3big.enrolment.model.Enrolment;
import com.example.springbd3big.enrolment.repository.EnrolmentRepository;
import com.example.springbd3big.enrolment.service.command.EnrolmentCommandService;
import com.example.springbd3big.student.dtos.StudentCreateRequest;
import com.example.springbd3big.student.dtos.StudentResponse;
import com.example.springbd3big.student.dtos.StudentUpdateRequest;
import com.example.springbd3big.student.model.Student;
import com.example.springbd3big.student.repository.StudentRepository;
import com.example.springbd3big.student.service.command.StudentCommandService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ConfigApp {

    private final EnrolmentCommandService enrolmentCommandService;
    private final StudentCommandService studentCommandService;
    private StudentRepository studentRepository;
    private EnrolmentRepository enrolmentRepository;

    public ConfigApp(StudentRepository studentRepository, EnrolmentRepository enrolmentRepository, EnrolmentCommandService enrolmentCommandService, StudentCommandService studentCommandService){
        this.studentRepository = studentRepository;
        this.enrolmentRepository = enrolmentRepository;
        this.enrolmentCommandService = enrolmentCommandService;
        this.studentCommandService = studentCommandService;


//        this.testFindAll();
//        this.testFindById();
//        this.testExistsByEmailJPQL();
//        this.testEnrollStudent();
//        this.testCreateStudent();
//        this.testUpdateStudent();
        this.testRemoveStudent();
    }

    public void testFindAll(){
        studentRepository.findAll().forEach(System.out::println);
    }

    public void testFindById(){
        System.out.println(studentRepository.findById(1L));
    }

    public void testExistsByEmailJPQL(){
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
        studentCommandService.deleteStudent(52L);

    }




}
