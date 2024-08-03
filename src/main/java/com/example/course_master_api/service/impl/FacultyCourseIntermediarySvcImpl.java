package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.FacultyCourseIntermediary;
import com.example.course_master_api.repository.FacultyCourseIntermediaryRepository;
import com.example.course_master_api.service.FacultyCourseIntermediarySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyCourseIntermediarySvcImpl implements FacultyCourseIntermediarySvc {

    private static final String NOT_FOUND = "Lo sentimos, no se encontró información con el id: ";

    @Autowired
    private FacultyCourseIntermediaryRepository facultyCourseIntermediaryRepository;

    @Override
    public List<FacultyCourseIntermediary> getAllFacultyCourseIntermediaries(){
        return facultyCourseIntermediaryRepository.findAll();
    }

    @Override
    public Optional<FacultyCourseIntermediary> getFacultyCourseIntermediaryById(Long id){
        return facultyCourseIntermediaryRepository.findById(id);
    }

    @Override
    public FacultyCourseIntermediary saveFacultyCourseIntermediary(FacultyCourseIntermediary fc){
        return facultyCourseIntermediaryRepository.save(fc);
    }

    @Override
    public FacultyCourseIntermediary updateFacultyCourseIntermediary(Long id, FacultyCourseIntermediary facultyCourseIntermediaryUpdate){
        FacultyCourseIntermediary facultyCourseIntermediary = facultyCourseIntermediaryRepository.findById(id).orElseThrow(()-> new RuntimeException(NOT_FOUND + id));
        facultyCourseIntermediary.setIdCourse(facultyCourseIntermediaryUpdate.getIdCourse());
        facultyCourseIntermediary.setIdFaculty(facultyCourseIntermediaryUpdate.getIdFaculty());
        facultyCourseIntermediaryRepository.save(facultyCourseIntermediary);
        return facultyCourseIntermediary;
    }

    @Override
    public FacultyCourseIntermediary deleteFacultyCourseIntermediary(Long id){
        FacultyCourseIntermediary facultyCourseIntermediary = facultyCourseIntermediaryRepository.findById(id).orElseThrow(()-> new RuntimeException(NOT_FOUND + id));
        facultyCourseIntermediaryRepository.delete(facultyCourseIntermediary);
        return facultyCourseIntermediary;
    }
}
