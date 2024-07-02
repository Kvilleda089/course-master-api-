package com.example.course_master_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@Entity
@Table(schema = "coursemaster", name = "teacher")
@EqualsAndHashCode(callSuper = false)
public class Teacher  extends Person implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid_teacher")
    private Long dbidTeacher;

    @Column(name = "id_faculty")
    private Long facultyId;
}
