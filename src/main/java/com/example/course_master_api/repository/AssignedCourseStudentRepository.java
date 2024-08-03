package com.example.course_master_api.repository;

import com.example.course_master_api.entity.AssignedCourseStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignedCourseStudentRepository extends JpaRepository<AssignedCourseStudent, Long> {
}
