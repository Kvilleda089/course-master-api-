package com.example.course_master_api.repository;

import com.example.course_master_api.entity.FacultyCourseIntermediary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyCourseIntermediaryRepository extends JpaRepository<FacultyCourseIntermediary, Long>{
}
