package com.example.course_master_api.service;

import com.example.course_master_api.entity.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultySvc {
    List<Faculty> getAllFaculty();
    Optional<Faculty> getFacultyById(Long id);
    Faculty addFaculty(Faculty faculty);
    Faculty updateFaculty(Long id, Faculty facultyUpdate);
    Faculty deleteFaculty(Long id);
}
