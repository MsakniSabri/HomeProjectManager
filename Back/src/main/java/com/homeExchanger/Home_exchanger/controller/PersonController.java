package com.homeExchanger.Home_exchanger.controller;

import com.homeExchanger.Home_exchanger.model.Person;
import com.homeExchanger.Home_exchanger.repository.UserRepository;
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
    UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<HttpStatus> connexion(){
        System.out.println("You are connected");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Person>> getAllUsers(@RequestParam(required = false) String lastName) {
        try {
            System.out.println("Get all users");
            List<Person> users = new ArrayList<>();

            if (lastName == null)
                userRepository.findAll().forEach(users::add);
            else
                userRepository.findBySurname(lastName).forEach(users::add);

            if(users.isEmpty()) {
                System.out.println("no content");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch ( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable("id") Long id) {
        Optional<Person> userData = userRepository.findById(id);
        System.out.println("Get user with id : " + id);
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@GetMapping("/users/findByEmail/{email_address}")
    public ResponseEntity<Person> getUserByEmail_address(@PathVariable("email_address") Long emailAddress) {
        Optional<Person> userData = userRepository.findByEmail_address("email_address");
        System.out.println("Get user with emailAddress : " + emailAddress);
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping("/users")
    public ResponseEntity<Person> createUser(@RequestBody Person user) {
        try{
            System.out.println("Modify a user");
            Person newUser = new Person();
            newUser.setName(user.getName());
            newUser.setSurname(user.getSurname());
            newUser.setEmailAddress(user.getEmailAddress());

            Person _user = userRepository.save(newUser);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Person> updateUser(@PathVariable("id") Long id, @RequestBody Person user) {
        Optional<Person> userData = userRepository.findById(id);

        if(userData.isPresent()) {
            Person _user = userData.get();
            _user.setSurname(user.getSurname());
            _user.setName(user.getName());
            _user.setEmailAddress(user.getEmailAddress());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            userRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}