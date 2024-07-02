package com.example.course_master_api.service.util;

import com.example.course_master_api.entity.Person;

public class EmailUtil {

    private static final String DOMINIO = "@edu.gt.com";

    public static String buildEmail(Person person) {
        String firstName = person.getFirstName().toLowerCase();
        String secondSurname = person.getSecondSurname().toLowerCase();
        String buildEmail = firstName.charAt(0) + secondSurname + DOMINIO;
        return buildEmail;
    }
}
