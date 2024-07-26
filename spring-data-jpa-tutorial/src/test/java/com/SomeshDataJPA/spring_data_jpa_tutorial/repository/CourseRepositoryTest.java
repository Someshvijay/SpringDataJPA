package com.SomeshDataJPA.spring_data_jpa_tutorial.repository;

import com.SomeshDataJPA.spring_data_jpa_tutorial.entity.Course;
import com.SomeshDataJPA.spring_data_jpa_tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public  void printCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses : " + courses);
    }

    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("AAA")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0,3);

        Pageable SecondPagewithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPagewithThreeRecords)
                .getContent();

        
        

        long totalElements =
                courseRepository.findAll(SecondPagewithTwoRecords)
                                .getTotalElements();

        long totalPages = courseRepository.findAll(SecondPagewithTwoRecords)
                        .getTotalPages();


        System.out.println("Total Elements : " + totalElements);

        System.out.println("Total Pages : " + totalPages);

        System.out.println("Course : " + courses);
    }


    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Course : " + courses);
    }
}