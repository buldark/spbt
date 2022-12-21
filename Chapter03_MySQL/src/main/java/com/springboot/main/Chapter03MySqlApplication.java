package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.springboot.main", "main.controller", "user.*"})
@SpringBootApplication
public class Chapter03MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter03MySqlApplication.class, args);
	}

}
