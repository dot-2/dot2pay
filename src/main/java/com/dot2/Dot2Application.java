package com.dot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Dot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Dot2Application.class, args);
	}

}
