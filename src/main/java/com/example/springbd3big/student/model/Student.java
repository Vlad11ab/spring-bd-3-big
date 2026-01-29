package com.example.springbd3big.student.model;

import com.example.springbd3big.book.model.Book;
import com.example.springbd3big.course.model.Course;
import com.example.springbd3big.enrolment.model.Enrolment;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "student",
               cascade = CascadeType.ALL,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    Set<Book> books = new HashSet<>();

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    Set<Enrolment> enrolments = new HashSet<>();

    @Column(name = "first_name")
    @NotBlank
    @Size(min = 3, max = 50, message = "size 3-50")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Size(min = 3, max = 50, message = "size 3-50")
    private String lastName;

    @Email
    @NotBlank
    @Size(min = 3, max = 50, message = "size 3-50")
    private String email;


    //BOOKS
    public void addBook(Book book){
        this.books.add(book);
        book.setStudent(this);
    }

    public void deleteBook(Book book){
        this.books.remove(book);
        book.setStudent(null);
    }

    //ENROLMENTS
    public void addEnrolment(Enrolment enrolment, Course course){
        this.enrolments.add(enrolment);
        enrolment.setStudent(this);
        enrolment.setCourse(course);
    }

    public void deleteEnrolments(Enrolment enrolment){
        this.enrolments.remove(enrolment);
        enrolment.setStudent(null);
        enrolment.setCourse(null);
    }







}
