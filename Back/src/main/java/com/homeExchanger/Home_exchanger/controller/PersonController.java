package com.homeExchanger.Home_exchanger.controller;

import com.homeExchanger.Home_exchanger.model.Person;
import com.homeExchanger.Home_exchanger.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(@RequestAttribute(required = false) String title){
        try{
            List<Person> persons = new ArrayList<Person>();

            if (title == null)
                personRepository.findAll().forEach((person) -> persons.add(person));
            else
                //personRepository.findByTitleContaining(title).forEach((person) -> persons.add(person));
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
