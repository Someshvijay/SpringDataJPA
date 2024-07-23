package com.SomeshDataJPA.spring_data_jpa_tutorial.repository;

import com.SomeshDataJPA.spring_data_jpa_tutorial.entity.Guardian;
import com.SomeshDataJPA.spring_data_jpa_tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("somesh@gmail.com")
                .firstName("Somesh")
                .lastName("Vijay")
                //.guardianName("Mohan")
                //.guardianEmail("Mohan@gmail.com")
                //.guardianMobile("9884344154")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("Mohan@gmail.com")
                .name("Mohan")
                .mobile("123456789")
                .build();

        Student student = Student.builder()
                .firstName("Rahul")
                .lastName("Durai")
                .emailId("Rahul@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }




    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByfirstName("Somesh");

        System.out.println("students : " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("So");

        System.out.println("students : " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Mohan");

        System.out.println("students : " + students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student students = studentRepository.getStudentByEmailAddress("somesh@gmail.com");

        System.out.println("students : " + students);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("somesh@gmail.com");

        System.out.println("Student FirstName : " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("somesh@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("somesh@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void updateStudentFirstNameByEmailAddressNative(){
        studentRepository.updateStudentNameByEmailId("HelloWorld", "Rahul@gmail.com");

    }



}