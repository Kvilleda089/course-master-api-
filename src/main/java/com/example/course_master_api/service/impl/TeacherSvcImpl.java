package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.Student;
import com.example.course_master_api.entity.Teacher;
import com.example.course_master_api.repository.TeacherRepository;
import com.example.course_master_api.service.TeacherSvc;
import com.example.course_master_api.service.util.EmailUtil;
import com.example.course_master_api.service.util.PersonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherSvcImpl implements TeacherSvc {

    private static final String NOT_FOUND = "Lo sentimos, no se encontró información con el id: ";
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        String email = EmailUtil.buildEmail(teacher);
        teacher.setEmail(email);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacherUpdate) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new RuntimeException(NOT_FOUND+ id));
        PersonUtil.updatePerson(teacher, teacherUpdate);
        teacher.setFacultyId(teacherUpdate.getFacultyId());
        return teacherRepository.save(teacher);
    }

  @Override
  public Teacher deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(NOT_FOUND+ id));
        teacherRepository.delete(teacher);
      return teacher;
  }

}
