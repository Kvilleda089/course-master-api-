package com.example.course_master_api.controller;

import com.example.course_master_api.entity.FacultyCourseIntermediary;
import com.example.course_master_api.service.FacultyCourseIntermediarySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/faculty-course-intermediaries")
public class FacultyCourseIntermediaryController {

    @Autowired
    private FacultyCourseIntermediarySvc facultyCourseIntermediarySvc;

    @GetMapping
    public ResponseEntity<List<FacultyCourseIntermediary>> getAllFacultyCourseIntermediaries() {
        return new ResponseEntity<>(facultyCourseIntermediarySvc.getAllFacultyCourseIntermediaries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FacultyCourseIntermediary>> getFacultyCourseIntermediaryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(facultyCourseIntermediarySvc.getFacultyCourseIntermediaryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FacultyCourseIntermediary> saveFacultyCourseIntermediary(@RequestBody FacultyCourseIntermediary fci) {
        return new ResponseEntity<>(facultyCourseIntermediarySvc.saveFacultyCourseIntermediary(fci), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyCourseIntermediary> updateFacultyCourseIntermediary(@PathVariable("id") Long id, @RequestBody FacultyCourseIntermediary fci) {
        return new ResponseEntity<>(facultyCourseIntermediarySvc.updateFacultyCourseIntermediary(id, fci), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacultyCourseIntermediary> deleteFacultyCourseIntermediary(@PathVariable("id") Long id) {
       return new ResponseEntity<>(facultyCourseIntermediarySvc.deleteFacultyCourseIntermediary(id), HttpStatus.OK) ;
    }
}
