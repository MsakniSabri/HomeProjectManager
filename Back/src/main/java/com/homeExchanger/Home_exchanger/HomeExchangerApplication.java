package com.homeExchanger.Home_exchanger;

import com.homeExchanger.Home_exchanger.model.Person;
import com.homeExchanger.Home_exchanger.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HomeExchangerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =
		SpringApplication.run(HomeExchangerApplication.class, args);
		PersonRepository personRepository = ctx.getBean(PersonRepository.class);
		personRepository.save(new Person("Baudchon"));
		personRepository.save(new Person("Fournet"));
		personRepository.save(new Person("Schafer"));
		personRepository.save(new Person("Msekni"));
		personRepository.findAll().forEach(t -> System.out.println(t.getName()));
		personRepository.deleteAll();
	}

}
