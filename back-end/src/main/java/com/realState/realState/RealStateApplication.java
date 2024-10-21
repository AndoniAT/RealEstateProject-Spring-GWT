package com.realState.realState;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RealStateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealStateApplication.class, args);
	}
	
	@GetMapping
	public List<String> realState(){
		return List.of(
				"Application: Real State",
				"Author: Andoni",
				"Date: 21/10/2024");
	}

}
