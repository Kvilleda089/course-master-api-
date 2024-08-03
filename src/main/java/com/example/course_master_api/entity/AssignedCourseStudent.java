package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "coursemaster", name = "assigned_course_student")
public class AssignedCourseStudent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid")
    private Long dbid;

    @Column(name = "id_course_")
    private Long idCourse;

    @Column(name = "id_student_")
    private Long idStudnet;

}
