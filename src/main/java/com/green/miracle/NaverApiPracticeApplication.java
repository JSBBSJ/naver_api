package com.green.miracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class NaverApiPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverApiPracticeApplication.class, args);
	}
	
	@Bean
	ObjectMapper ObjectMapper() {
		return new ObjectMapper();
	}

}
