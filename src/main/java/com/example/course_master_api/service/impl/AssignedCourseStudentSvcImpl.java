package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.AssignedCourseStudent;
import com.example.course_master_api.repository.AssignedCourseStudentRepository;
import com.example.course_master_api.service.AssignedCourseStudentSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignedCourseStudentSvcImpl  implements AssignedCourseStudentSvc {

    private static  final String NOT_FOUND = "Lo sentimos, no se ha encontrado información con el ID: ";
    @Autowired
    private AssignedCourseStudentRepository assignedCourseStudentRepository;


    @Override
    public List<AssignedCourseStudent> getAllAssignedCourseStudents(){
        return assignedCourseStudentRepository.findAll();
    }

    @Override
    public Optional<AssignedCourseStudent> getAssignedCourseStudentById(Long id){
        return assignedCourseStudentRepository.findById(id);
    }

    @Override
    public AssignedCourseStudent addAssignedCourseStudent(AssignedCourseStudent assignedCourseStudent){
        return assignedCourseStudentRepository.save(assignedCourseStudent);
    }

    @Override
    public AssignedCourseStudent updateAssignedCourseStudent(Long id, AssignedCourseStudent assignedCourseStudentUpdate){
        AssignedCourseStudent assigneCourseStudent = assignedCourseStudentRepository.findById(id).orElseThrow(()-> new RuntimeException(NOT_FOUND + id));
        assigneCourseStudent.setIdCourse(assignedCourseStudentUpdate.getIdCourse());
        assigneCourseStudent.setIdStudnet(assignedCourseStudentUpdate.getIdStudnet());
        return assignedCourseStudentRepository.save(assigneCourseStudent);
    }

    @Override
    public AssignedCourseStudent deleteAssignedCourseStudent(Long id){
        AssignedCourseStudent assignedCourseStudent = assignedCourseStudentRepository.findById(id).orElseThrow(()-> new RuntimeException(NOT_FOUND + id));
         assignedCourseStudentRepository.delete(assignedCourseStudent);
         return assignedCourseStudent;
    }


}
