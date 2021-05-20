package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmailAddress(String emailAddress);
    List<Person> findBySurname(String surname);
}
