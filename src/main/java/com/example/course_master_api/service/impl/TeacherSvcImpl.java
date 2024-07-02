package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.Student;
import com.example.course_master_api.entity.Teacher;
import com.example.course_master_api.repository.TeacherRepository;
import com.example.course_master_api.service.TeacherSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherSvcImpl implements TeacherSvc {
    private final static String DOMINIO = "@edu.gt.com";

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
        String email = buildEmail(teacher);
        teacher.setEmail(email);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacherUpdate) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró información con el id : "+ id));
        String buildEmail = buildEmail(teacher);
        teacher.setFirstName(teacherUpdate.getFirstName());
        teacher.setSecondName(teacherUpdate.getSecondName());
        teacher.setSurName(teacherUpdate.getSurName());
        teacher.setSecondSurname(teacherUpdate.getSecondSurname());
        teacher.setBirthDate(teacherUpdate.getBirthDate());
        teacher.setAge(teacherUpdate.getAge());
        teacher.setEntryYear(teacherUpdate.getEntryYear());
        teacher.setStatus(teacherUpdate.getStatus());
        teacher.setCardCode(teacherUpdate.getCardCode());
        teacher.setEmail(buildEmail);
        teacher.setFacultyId(teacherUpdate.getFacultyId());
        return teacherRepository.save(teacher);
    }

  @Override
  public Teacher deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se ha encontrado registro con el id : "+ id));
        teacherRepository.delete(teacher);
      return teacher;
  }

  public String buildEmail(Teacher teacher){
        String firstName = teacher.getFirstName().toLowerCase();
        String secondSurname = teacher.getSecondSurname().toLowerCase();
        String buildEmail = firstName.charAt(0) + secondSurname + DOMINIO;
        return buildEmail;
    }
}
