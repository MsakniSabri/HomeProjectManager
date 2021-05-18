package com.homeExchanger.Home_exchanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HomeExchangerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =
		SpringApplication.run(HomeExchangerApplication.class, args);
	}

}
