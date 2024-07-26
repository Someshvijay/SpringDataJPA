package com.SomeshDataJPA.spring_data_jpa_tutorial.repository;

import com.SomeshDataJPA.spring_data_jpa_tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
