package com.example.springbd3big.enrolment.repository;

import com.example.springbd3big.enrolment.model.Enrolment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

    @Override
    @EntityGraph(attributePaths = {"student", "course"})
    List<Enrolment> findAll();

    @Override
    @EntityGraph(attributePaths = {"student", "course"})
    Optional<Enrolment> findById(Long enrolmentId);
}
