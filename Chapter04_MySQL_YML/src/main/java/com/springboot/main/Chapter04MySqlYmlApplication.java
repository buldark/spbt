package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.springboot.main", "main.controller", "user.*"})
@SpringBootApplication
public class Chapter04MySqlYmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter04MySqlYmlApplication.class, args);
	}

}
