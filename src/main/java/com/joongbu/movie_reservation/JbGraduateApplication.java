package com.joongbu.movie_reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class JbGraduateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbGraduateApplication.class, args);
	}

}
