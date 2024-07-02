package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.Faculty;
import com.example.course_master_api.repository.FacultyRepository;
import com.example.course_master_api.service.FacultySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultySvcImpl implements FacultySvc {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional<Faculty> getFacultyById(Long id){
        return facultyRepository.findById(id);
    }

    @Override
    public Faculty addFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty facultyUpdate){
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro la facultad con el id "+ id));
        faculty.setFacultyName(facultyUpdate.getFacultyName());
        faculty.setFacultyCode(facultyUpdate.getFacultyCode());
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty deleteFaculty(Long id){
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro la facultad con el id "+ id));
        facultyRepository.delete(faculty);
        return faculty;
    }
}
