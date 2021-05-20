package com.homeExchanger.Home_exchanger.controller;

import com.homeExchanger.Home_exchanger.model.Housing;
import com.homeExchanger.Home_exchanger.model.Person;
import com.homeExchanger.Home_exchanger.repository.HousingRepository;
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
public class HousingController {

    @Autowired
    HousingRepository housingRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/housings")
    public ResponseEntity<List<Housing>> getAllHousings(@RequestParam(required = false) String title, @RequestParam(required = false) Boolean isAvailable) {
        try{
            System.out.println("Get all housings");
            List<Housing> housings = new ArrayList<>();

            if (title == null && isAvailable == null)
                housingRepository.findAll().forEach(housings::add);
            else if (title != null && isAvailable != null)
                housingRepository.findByTitleAndAvailable(title, isAvailable).forEach(housings::add);
            else if (title != null)
                housingRepository.findByTitle(title).forEach(housings::add);
            else
                housingRepository.findByAvailable(isAvailable).forEach(housings::add);

            if(housings.isEmpty()) {
                System.out.println("No content");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(housings, HttpStatus.OK);
        } catch ( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/housings/{id}")
    public ResponseEntity<Housing> getHousingById(@PathVariable("id") Long id) {
        Optional<Housing> housingData = housingRepository.findById(id);
        System.out.println("Get housing with id : " + id);
        if(housingData.isPresent()) {
            return new ResponseEntity<>(housingData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/persons/{personId}/housings")
    public ResponseEntity<List<Housing>> getAllHousingsByPersonId(@PathVariable (value = "personId") Long personId){
        Optional<Person> personData = personRepository.findById(personId);
        System.out.println("Get housings of the user : " + personId);
        if(personData.isPresent()){
            List<Housing> housings = new ArrayList<>();
            housingRepository.findByPerson(personData.get()).forEach(housings::add);
            return new ResponseEntity<>(housings, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persons/{personId}/housings")
    public ResponseEntity<Housing> createHousing(@PathVariable Long personId, @RequestBody Housing housing){
        try{
            Optional<Person> personData = personRepository.findById(personId);
            System.out.println("Create a housing for the user : " + personId);
            if(personData.isPresent()) {
                Housing newHousing = new Housing(personData.get());
                newHousing.setAddress(housing.getAddress());
                newHousing.setTitle(housing.getTitle());
                newHousing.setLivingSpace(housing.getLivingSpace());
                newHousing.setDescription(housing.getDescription());
                newHousing.setAvailable(true);
                Housing _housing = housingRepository.save(newHousing);
                return new ResponseEntity<>(_housing, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/housings{housingId}")
    public ResponseEntity<Housing> updateHousing(@PathVariable Long housingId, @RequestBody Housing housing) {

        Optional<Housing> housingData = housingRepository.findById(housingId);
        if(housingData.isPresent()) {
            Housing _housing = housingData.get();
            _housing.setAddress(housing.getAddress());
            _housing.setTitle(housing.getTitle());
            _housing.setLivingSpace(housing.getLivingSpace());
            _housing.setDescription(housing.getDescription());
            _housing.setAvailable(housing.getAvailable());
            return new ResponseEntity<>(housingRepository.save(_housing), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/housings/{id}")
    public ResponseEntity<HttpStatus> deleteHousing (@PathVariable("id") Long id){
        try{
            housingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/housings")
    public ResponseEntity<HttpStatus> deleteAllHousings() {
        try{
            housingRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
