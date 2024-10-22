package com.realState.realEstate.user;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.realState.realEstate.Estate.Estate;
import com.realState.realEstate.Estate.EstateRepository;

@Configuration
public class UserConfig {
	@Bean
    @Order(1)
	CommandLineRunner commandLineRunner(UserRepository userRepository, EstateRepository estateRepository) {
		return args -> {
			UserApp andoni = new UserApp("Andoni", "Alonso", "andoniexemple@exemple.com", LocalDate.of(1996, Month.DECEMBER, 11) );
			UserApp maria = new UserApp("Maria", "Tort", "mariaexemple@exemple.com", LocalDate.of(2000, Month.FEBRUARY, 20));
			UserApp thibaud = new UserApp("Thibaud", "Guzman", "thibaudexemple@exemple.com", LocalDate.of(1999, Month.MARCH, 10));
			UserApp ana = new UserApp("Ana", "Correa", "anaexemple@exemple.com", LocalDate.of(1998, Month.APRIL, 22));
			UserApp miriam = new UserApp("Miriam", "Ornelas", "miriamexemple@exemple.com", LocalDate.of(2001, Month.DECEMBER, 23));
			
			// Save in db
			userRepository.saveAll(
					List.of(andoni, maria, thibaud, ana, miriam)
					);
			
			
		};
	}
}
