package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(schema = "courseMaster", name = "faculty")
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid_faculty")
    private Long dbidFaculty;

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(name = "faculty_code")
    private String facultyCode;

}
