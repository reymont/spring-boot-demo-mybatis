package com.example;

import com.example.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.controllers", "com.example.services"})
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}
}
