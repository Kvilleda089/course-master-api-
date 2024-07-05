package com.example.course_master_api.controller;

import com.example.course_master_api.entity.AssignedCourseTeacher;
import com.example.course_master_api.service.AssignedCourseTeacherSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/assigned-courses-teachers")
public class AssignedCourseTeacherController {

    @Autowired
    private AssignedCourseTeacherSvc assignedCourseTeacherSvc;


    @GetMapping
    public ResponseEntity<List<AssignedCourseTeacher>> getAllAssignedCourseTeachers() {
        return new ResponseEntity<>(assignedCourseTeacherSvc.getAssignedCourseTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AssignedCourseTeacher>> getAssignedCourseTeacher(@PathVariable("id") Long id) {
        return new ResponseEntity<>(assignedCourseTeacherSvc.getAssignedCourseTeacherById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AssignedCourseTeacher> save(@RequestBody AssignedCourseTeacher assignedCourseTeacher) {
        return new ResponseEntity<>(assignedCourseTeacherSvc.addAssignedCourseTeacher(assignedCourseTeacher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignedCourseTeacher> update(@PathVariable("id") Long id, @RequestBody AssignedCourseTeacher assignedCourseTeacher) {
        return new ResponseEntity<>(assignedCourseTeacherSvc.updateAssignedCourseTeacher(id, assignedCourseTeacher), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssignedCourseTeacher> delete(@PathVariable("id") Long id) {
      return new ResponseEntity<>(  assignedCourseTeacherSvc.deleteAssignedCourseTeacher(id), HttpStatus.OK);
    }
}
