package com.example.course_master_api.service.util;

import com.example.course_master_api.entity.Person;

public class PersonUtil {

    public static void updatePerson(Person person, Person personUpdate){
        person.setFirstName(personUpdate.getFirstName());
        person.setSecondName(personUpdate.getSecondName());
        person.setSurName(personUpdate.getSurName());
        person.setSecondSurname(personUpdate.getSecondSurname());
        person.setBirthDate(personUpdate.getBirthDate());
        person.setAge(personUpdate.getAge());
        person.setEntryYear(personUpdate.getEntryYear());
        person.setStatus(personUpdate.getStatus());
        person.setCardCode(personUpdate.getCardCode());
        person.setEmail(personUpdate.getEmail());
    }
}
