package com.example.course_master_api.service;

import com.example.course_master_api.entity.Student;

import java.util.List;

public interface StudentSvc {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student student);
    Student deleteStudent(Long id);
}
