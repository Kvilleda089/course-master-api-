package com.example.course_master_api.service;

import com.example.course_master_api.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherSvc {

    List<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherById(Long id);
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Long id, Teacher teacher);
    Teacher deleteTeacher(Long id);
}
