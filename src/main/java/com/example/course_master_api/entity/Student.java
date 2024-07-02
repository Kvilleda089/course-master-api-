package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@Entity
@Table(schema = "coursemaster", name = "student")
@EqualsAndHashCode(callSuper = false)
public class Student extends Person implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid_student")
    private Long dbidStudent;

    @Column(name = "faculty_id")
    private Long facultyId;
}
