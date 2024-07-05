package com.example.course_master_api.service;

import com.example.course_master_api.entity.AssignedCourseTeacher;

import java.util.List;
import java.util.Optional;

public interface AssignedCourseTeacherSvc {

    List<AssignedCourseTeacher> getAssignedCourseTeachers();
    Optional<AssignedCourseTeacher> getAssignedCourseTeacherById(Long id);
    AssignedCourseTeacher addAssignedCourseTeacher(AssignedCourseTeacher teacher);
    AssignedCourseTeacher updateAssignedCourseTeacher(Long id, AssignedCourseTeacher teacher);
    AssignedCourseTeacher deleteAssignedCourseTeacher(Long id);
}
