package com.dot2.dot2pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableCaching
@EnableJpaAuditing
@SpringBootApplication
public class Dot2payApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dot2payApplication.class, args);
	}

}
