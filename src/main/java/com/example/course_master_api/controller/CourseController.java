package com.example.course_master_api.controller;

import com.example.course_master_api.entity.Course;
import com.example.course_master_api.service.CourseSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/courses")
public class CourseController {

    @Autowired
    private CourseSvc courseSvc;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseSvc.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(courseSvc.getCourseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseSvc.addCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course) {
        return  new ResponseEntity<>(courseSvc.updateCourse(id, course), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") Long id) {
        return  new ResponseEntity<>(courseSvc.deleteCourse(id), HttpStatus.OK);
    }
}
