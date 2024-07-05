package com.example.course_master_api.service;

import com.example.course_master_api.entity.FacultyCourseIntermediary;

import java.util.List;
import java.util.Optional;

public interface FacultyCourseIntermediarySvc {

    List<FacultyCourseIntermediary> getAllFacultyCourseIntermediaries();
    Optional<FacultyCourseIntermediary> getFacultyCourseIntermediaryById(Long id);
    FacultyCourseIntermediary saveFacultyCourseIntermediary(FacultyCourseIntermediary fc);
    FacultyCourseIntermediary updateFacultyCourseIntermediary(Long id, FacultyCourseIntermediary fc);
    FacultyCourseIntermediary deleteFacultyCourseIntermediary(Long id);
}
