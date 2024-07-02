package com.example.course_master_api.service;

import com.example.course_master_api.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentSvc {

    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student student);
    Student deleteStudent(Long id);
}
