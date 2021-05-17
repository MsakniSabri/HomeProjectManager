package com.homeExchanger.Home_exchanger;

import com.homeExchanger.Home_exchanger.model.User;
import com.homeExchanger.Home_exchanger.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HomeExchangerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =
		SpringApplication.run(HomeExchangerApplication.class, args);
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		userRepository.save(new User("Baudchon"));
		userRepository.save(new User("Fournet"));
		userRepository.save(new User("Schafer"));
		userRepository.save(new User("Msekni"));
		userRepository.findAll().forEach(t -> System.out.println(t.getLastName()));
		userRepository.deleteAll();
	}

}
