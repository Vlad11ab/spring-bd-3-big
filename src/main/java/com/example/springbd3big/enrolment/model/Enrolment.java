package com.example.springbd3big.enrolment.model;

import com.example.springbd3big.course.model.Course;
import com.example.springbd3big.student.model.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enrolment")
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id"
    )
    private Course course;

}
