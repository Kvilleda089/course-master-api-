package com.example.course_master_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class Person implements Serializable {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "surname")
    private String surName;

    @Column(name = "second_surname")
    private String secondSurname;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "age")
    private Long age;

    @Column(name = "entry_year")
    private Date entryYear;

    @Column(name = "status")
    private String status;

    @Column(name = "card_code")
    private String cardCode;

    @Column(name = "email")
    private String email;
}