package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.Student;
import com.example.course_master_api.repository.StudentRepository;
import com.example.course_master_api.service.StudentSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSvcImpl implements StudentSvc {

    private final static String DOMINIO = "@edu.gt.com";
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student addStudent(Student student) {
        String email = buildEmail(student);
        student.setEmail(email);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student studentUpdate) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Lo sentimos, no se encontro Estudiante a actualizar con el ID: "+ id));
        String buildEmail = buildEmail(student);
        student.setFirstName(studentUpdate.getFirstName());
        student.setSecondName(studentUpdate.getSecondName());
        student.setSurName(studentUpdate.getSurName());
        student.setSecondSurname(studentUpdate.getSecondSurname());
        student.setBirthDate(studentUpdate.getBirthDate());
        student.setAge(studentUpdate.getAge());
        student.setEntryYear(studentUpdate.getEntryYear());
        student.setStatus(studentUpdate.getStatus());
        student.setCardCode(studentUpdate.getCardCode());
        student.setEmail(buildEmail);
        student.setFacultyId(studentUpdate.getFacultyId());
        return studentRepository.save(student);
    }


    public String buildEmail(Student student){
        String firstName = student.getFirstName().toLowerCase();
        String secondSurname = student.getSecondSurname().toLowerCase();
        String buildEmail = firstName.charAt(0) + secondSurname + DOMINIO;
        return buildEmail;
    }

    @Override
    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("No se encontró registro con el id "+ id));
        studentRepository.delete(student);
        return student;

    }

}
