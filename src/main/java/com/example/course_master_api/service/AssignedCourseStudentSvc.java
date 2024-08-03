package com.example.course_master_api.service;

import com.example.course_master_api.entity.AssignedCourseStudent;

import java.util.List;
import java.util.Optional;

public interface AssignedCourseStudentSvc {

    List<AssignedCourseStudent> getAllAssignedCourseStudents();
    Optional<AssignedCourseStudent> getAssignedCourseStudentById(Long dbid);
    AssignedCourseStudent addAssignedCourseStudent(AssignedCourseStudent assignedCourseStudent);
    AssignedCourseStudent updateAssignedCourseStudent(Long id, AssignedCourseStudent assignedCourseStudent);
    AssignedCourseStudent deleteAssignedCourseStudent(Long id);
}
