package com.homeExchanger.Home_exchanger.repository;

import com.homeExchanger.Home_exchanger.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByTitleContaining(String title);

}
