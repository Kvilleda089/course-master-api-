package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.Course;
import com.example.course_master_api.repository.CourseRepository;
import com.example.course_master_api.service.CourseSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseSvcImpl implements CourseSvc {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course>  getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course courseUpdate) {
       Course course = courseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se ha encontrado ningún curso con el id " + id));
        course.setCourseName(courseUpdate.getCourseName());
        course.setCourseStartTime(courseUpdate.getCourseStartTime());
        course.setCourseEndTime(courseUpdate.getCourseEndTime());
        course.setNumberSemester(courseUpdate.getNumberSemester());
       return courseRepository.save(course);
    }

    @Override
    public Course deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró información con el id: "+ id));
        courseRepository.delete(course);
        return course;
    }
}
