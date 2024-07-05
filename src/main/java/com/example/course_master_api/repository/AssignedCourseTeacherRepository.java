package com.example.course_master_api.repository;

import com.example.course_master_api.entity.AssignedCourseTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedCourseTeacherRepository extends JpaRepository<AssignedCourseTeacher, Long> {
}
