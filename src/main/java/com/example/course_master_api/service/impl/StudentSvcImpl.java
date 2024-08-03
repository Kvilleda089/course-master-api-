package com.example.course_master_api.service.impl;

import com.example.course_master_api.entity.Student;
import com.example.course_master_api.repository.StudentRepository;
import com.example.course_master_api.service.StudentSvc;
import com.example.course_master_api.service.exception.NotFoundData;
import com.example.course_master_api.service.util.EmailUtil;
import com.example.course_master_api.service.util.PersonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentSvcImpl implements StudentSvc {
    private static final String NOT_FOUND = "Lo sentimos, no se encontró información con el id: ";

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundData(NOT_FOUND + id));
        return student;
    }

    @Override
    public Student addStudent(Student student) {
        String email = EmailUtil.buildEmail(student);
        student.setEmail(email.trim());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student studentUpdate) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new NotFoundData(NOT_FOUND+ id));
        PersonUtil.updatePerson(student, studentUpdate);
        student.setFacultyId(studentUpdate.getFacultyId());
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->new NotFoundData(NOT_FOUND+ id));
        studentRepository.delete(student);
        return student;
    }

}
