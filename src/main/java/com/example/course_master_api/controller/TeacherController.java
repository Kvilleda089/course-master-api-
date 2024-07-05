package com.example.course_master_api.controller;

import com.example.course_master_api.entity.Teacher;
import com.example.course_master_api.service.TeacherSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherSvc teacherSvc;

    @GetMapping
    public ResponseEntity<List<Teacher>>getAllTeachers() {
        return new ResponseEntity<>(teacherSvc.getAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Teacher>>getTeacher(@PathVariable("id") Long id) {
        return new ResponseEntity<>(teacherSvc.getTeacherById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherSvc.addTeacher(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherSvc.updateTeacher(id, teacher), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable("id") Long id) {
        return new ResponseEntity<>(teacherSvc.deleteTeacher(id), HttpStatus.OK);
    }
}
