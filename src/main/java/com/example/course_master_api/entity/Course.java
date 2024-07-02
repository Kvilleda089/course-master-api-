package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Table(schema = "courseMaster", name = "course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid_course")
    private Long dbidCourse;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_start_time")
    private LocalTime courseStartTime;

    @Column(name = "course_end_time")
    private LocalTime courseEndTime;

    @Column(name = "number_semester")
    private Long numberSemester;
}
