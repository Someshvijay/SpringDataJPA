package com.SomeshDataJPA.spring_data_jpa_tutorial.repository;

import com.SomeshDataJPA.spring_data_jpa_tutorial.entity.Course;
import com.SomeshDataJPA.spring_data_jpa_tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDSA = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("HELLO")
                .lastName("World")
//                .courses(List.of(courseDSA,courseJAVA))
                .build();

        teacherRepository.save(teacher);
    }
}