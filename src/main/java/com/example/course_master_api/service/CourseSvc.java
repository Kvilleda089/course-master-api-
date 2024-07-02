package com.example.course_master_api.service;

import com.example.course_master_api.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseSvc {
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course addCourse(Course course);
    Course updateCourse(Long idCourse, Course course);
    Course deleteCourse(Long idCourse);
}
