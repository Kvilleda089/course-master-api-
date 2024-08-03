package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

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

    @Column(name = "course_start_time")
    private LocalTime courseStartTime;

    @Column(name = "course_end_time")
    private LocalTime courseEndTime;
}
