package com.example.course_master_api.controller;

import com.example.course_master_api.entity.Student;
import com.example.course_master_api.service.StudentSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/students")
public class StudentController {

    @Autowired
    private StudentSvc studentSvc;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentSvc.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student>  getStudentById(@PathVariable("id") Long id) {
        return studentSvc.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentSvc.addStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return new ResponseEntity<>(studentSvc.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentSvc.deleteStudent(id), HttpStatus.OK);
    }
}