package com.example.course_master_api.controller;

import com.example.course_master_api.entity.AssignedCourseStudent;
import com.example.course_master_api.service.AssignedCourseStudentSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/assigned-courses-students")
public class AsignedCourseStudentController {

    @Autowired
    private AssignedCourseStudentSvc assignedCourseStudentSvc;

    @GetMapping
    public ResponseEntity<List<AssignedCourseStudent>> getAssignedCourseStudents() {
        return new ResponseEntity<>(assignedCourseStudentSvc.getAllAssignedCourseStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AssignedCourseStudent>> getAssignedCourseStudentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(assignedCourseStudentSvc.getAssignedCourseStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AssignedCourseStudent> saveAssignedCourseStudent(@RequestBody AssignedCourseStudent assignedCourseStudent) {
        return new ResponseEntity<>(assignedCourseStudentSvc.addAssignedCourseStudent(assignedCourseStudent), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignedCourseStudent> udateAssignedCourseStudentById(@PathVariable("id") Long id, @RequestBody AssignedCourseStudent assignedCourseStudent) {
        return new ResponseEntity<>(assignedCourseStudentSvc.updateAssignedCourseStudent(id, assignedCourseStudent), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssignedCourseStudent> deleteAssignedCourseStudentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(assignedCourseStudentSvc.deleteAssignedCourseStudent(id), HttpStatus.OK);
    }
}
