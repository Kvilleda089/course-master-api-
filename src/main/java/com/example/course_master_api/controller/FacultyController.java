package com.example.course_master_api.controller;

import com.example.course_master_api.entity.Faculty;
import com.example.course_master_api.service.FacultySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/facultys")
public class FacultyController {

    @Autowired
    private FacultySvc facultySvc;

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultySvc.getAllFaculty();
    }

    @GetMapping("/{id}")
    public Optional<Faculty> getFacultyById(@PathVariable("id") Long id) {
        return facultySvc.getFacultyById(id);
    }

    @PostMapping
    public ResponseEntity<Faculty> saveFaculty(@RequestBody Faculty faculty) {
        return new ResponseEntity<>(facultySvc.addFaculty(faculty), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        return new ResponseEntity<>(facultySvc.updateFaculty(id, faculty), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable("id") Long id) {
        return new ResponseEntity<>(facultySvc.deleteFaculty(id), HttpStatus.OK);
    }
}
