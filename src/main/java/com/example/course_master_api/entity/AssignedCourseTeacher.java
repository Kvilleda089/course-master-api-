package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "coursemaster", name = "assigned_course")
public class AssignedCourseTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid")
    private Long dbid;

    @Column(name = "course_dbid")
    private Long courseDbid;

    @Column(name = "teacher_dbid")
    private Long teacherDbid;
}
