package com.example.CATME;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CatmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatmeApplication.class, args);
		System.out.print("Hello hi");
	}
}
