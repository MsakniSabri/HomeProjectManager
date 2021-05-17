package com.homeExchanger.Home_exchanger.controller;

import com.homeExchanger.Home_exchanger.model.User;
import com.homeExchanger.Home_exchanger.repository.UserRepository;
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
    UserRepository userRepository;

    @GetMapping("/persons")
    public ResponseEntity<List<User>> getAllPersons(@RequestAttribute(required = false) String title){
        try{
            List<User> users = new ArrayList<User>();

            if (title == null)
                userRepository.findAll().forEach((user) -> users.add(user));
            else
                //personRepository.findByTitleContaining(title).forEach((person) -> persons.add(person));
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
