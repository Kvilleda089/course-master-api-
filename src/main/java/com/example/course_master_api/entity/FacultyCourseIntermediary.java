package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "courseMaster", name = "faculty_course_intermediary")
public class FacultyCourseIntermediary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid")
    private long dbid;

    @Column(name = "id_course")
    private Long idCourse;

    @Column(name = "dbid_faculty")
    private Long idFaculty;

}
