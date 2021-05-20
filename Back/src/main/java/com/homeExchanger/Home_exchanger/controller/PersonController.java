package com.homeExchanger.Home_exchanger.controller;

import com.homeExchanger.Home_exchanger.model.Person;
import com.homeExchanger.Home_exchanger.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public ResponseEntity<HttpStatus> connexion(){
        System.out.println("You are connected");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String surname) {
        try {
            System.out.println("Get all persons");
            List<Person> persons = new ArrayList<>();

            if (surname == null)
                personRepository.findAll().forEach(persons::add);
            else
                personRepository.findBySurname(surname).forEach(persons::add);

            if(persons.isEmpty()) {
                System.out.println("No content");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch ( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Optional<Person> personData = personRepository.findById(id);
        System.out.println("Get person with id : " + id);
        if (personData.isPresent()) {
            return new ResponseEntity<>(personData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person/email/{emailAddress}")
    public ResponseEntity<Person> getPersonByEmailAddress(@PathVariable("emailAddress") String emailAddress) {
        Optional<Person> personData = personRepository.findByEmailAddress(emailAddress);
        System.out.println("Get person with emailAddress : " + emailAddress);
        if (personData.isPresent()) {
            return new ResponseEntity<>(personData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try{
            System.out.println("Create a person");
            Person newPerson = new Person();
            newPerson.setName(person.getName());
            newPerson.setSurname(person.getSurname());
            System.out.println(person.getEmailAddress());
            newPerson.setEmailAddress(person.getEmailAddress());

            Person _person = personRepository.save(newPerson);
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        Optional<Person> personData = personRepository.findById(id);

        if(personData.isPresent()) {
            Person _person = personData.get();
            _person.setSurname(person.getSurname());
            _person.setName(person.getName());
            _person.setEmailAddress(person.getEmailAddress());
            return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") Long id){
        try {
            System.out.println("Delete person :" + id);
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/persons")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        try {
            personRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}