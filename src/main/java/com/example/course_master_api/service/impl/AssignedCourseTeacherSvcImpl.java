package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.AssignedCourseTeacher;
import com.example.course_master_api.repository.AssignedCourseTeacherRepository;
import com.example.course_master_api.service.AssignedCourseTeacherSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignedCourseTeacherSvcImpl implements AssignedCourseTeacherSvc {

    private static final String NOT_FOUND = "Lo sentimos, no se ha encontrado información con el id: ";
    @Autowired
    private AssignedCourseTeacherRepository assignedCourseTeacherRepository;

    @Override
    public List<AssignedCourseTeacher> getAssignedCourseTeachers(){
        return assignedCourseTeacherRepository.findAll();
    }

    @Override
    public Optional<AssignedCourseTeacher> getAssignedCourseTeacherById(Long id){
        return assignedCourseTeacherRepository.findById(id);
    }

    @Override
    public AssignedCourseTeacher addAssignedCourseTeacher(AssignedCourseTeacher assignedCourseTeacher){
        return assignedCourseTeacherRepository.save(assignedCourseTeacher);
    }

    @Override
    public AssignedCourseTeacher updateAssignedCourseTeacher(Long id, AssignedCourseTeacher assignedCourseTeacherUpdate){
        AssignedCourseTeacher assignedCourseTeacher = assignedCourseTeacherRepository.findById(id).orElseThrow(()-> new RuntimeException(NOT_FOUND + id));
        assignedCourseTeacher.setCourseDbid(assignedCourseTeacherUpdate.getCourseDbid());
        assignedCourseTeacher.setTeacherDbid(assignedCourseTeacherUpdate.getTeacherDbid());
        return assignedCourseTeacherRepository.save(assignedCourseTeacher);
    }

    @Override
    public AssignedCourseTeacher deleteAssignedCourseTeacher(Long id){
        AssignedCourseTeacher assignedCourseTeacher = assignedCourseTeacherRepository.findById(id).orElseThrow(()-> new RuntimeException(NOT_FOUND + id));
        assignedCourseTeacherRepository.delete(assignedCourseTeacher);
        return assignedCourseTeacher;
    }
}
