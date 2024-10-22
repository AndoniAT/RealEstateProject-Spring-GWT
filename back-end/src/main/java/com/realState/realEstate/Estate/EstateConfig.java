package com.realState.realEstate.Estate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import com.realState.realEstate.user.UserApp;
import com.realState.realEstate.user.UserRepository;

@Configuration
@Transactional
public class EstateConfig {
	@Bean
	@Order(2)
	CommandLineRunner estateCommandLineRunner(EstateRepository estateRepository, UserRepository userRepository) {
		return args -> {
			UserApp andoni = userRepository.findUserByEmail("andoniexemple@exemple.com")
	                .orElseThrow(() -> new IllegalStateException("User not found"));
	        
			UserApp thibaud = userRepository.findUserByEmail("thibaudexemple@exemple.com")
	                .orElseThrow(() -> new IllegalStateException("User not found"));

			UserApp maria = userRepository.findUserByEmail("mariaexemple@exemple.com")
	                .orElseThrow(() -> new IllegalStateException("User not found"));
			
			UserApp ana = userRepository.findUserByEmail("anaexemple@exemple.com")
	                .orElseThrow(() -> new IllegalStateException("User not found"));
			
	        List<Estate> estates_andoni = new ArrayList<>();
			Estate estate_lh = new Estate( 600.50, "France", "76600", 55, "Republique", 100);
			Estate estate_mx = new Estate( 800.00, "Mexico", "76803", 10, "Miguel Hidalgo", 150 );
			estate_lh.setOwner(andoni);
			estate_mx.setOwner(andoni);
			estates_andoni.add(estate_lh);
			estates_andoni.add(estate_mx);
			andoni.setEstatesList(estates_andoni);
			userRepository.save(andoni);
			
			List<Estate> estates_thibaud = new ArrayList<>();
			Estate estate_caen = new Estate( 960.00, "France", "76800", 10, "Jules Verne", 80 );
			estate_caen.setOwner(thibaud);
			estates_thibaud.add(estate_caen);
			thibaud.setEstatesList(estates_thibaud);
			userRepository.save(thibaud);
			
			List<Estate> estates_maria = new ArrayList<>();
			Estate estate_rouan = new Estate( 100.00, "France", "77800", 66, "Jules Verne", 110 );
			Estate estate_london = new Estate( 2000.00, "England", "78990", 11, "Mary Shelley", 150 );
			Estate estate_barcelona = new Estate( 700.00, "Spain", "11990", 11, "Cervantes", 66 );
			estate_rouan.setOwner(maria);
			estate_london.setOwner(maria);
			estate_barcelona.setOwner(maria);
			estates_maria.add(estate_rouan);
			estates_maria.add(estate_london);
			estates_maria.add(estate_barcelona);
			maria.setEstatesList(estates_maria);
			userRepository.save(maria);
			
			List<Estate> estates_ana = new ArrayList<>();
			Estate estate_leon = new Estate( 500.00, "Mexico", "88800", 66, "Maria ines", 90 );
			Estate estate_rome = new Estate( 2000.00, "Italy", "78995", 44, "Mundorini", 56 );
			Estate estate_madrid = new Estate( 790.00, "Spain", "11290", 5, "Picasso", 88 );
			estate_leon.setOwner(ana);
			estate_rome.setOwner(ana);
			estate_madrid.setOwner(ana);
			estates_ana.add(estate_leon);
			estates_ana.add(estate_rome);
			estates_ana.add(estate_madrid);
			ana.setEstatesList(estates_ana);
			userRepository.save(ana);
		};
	}
}
