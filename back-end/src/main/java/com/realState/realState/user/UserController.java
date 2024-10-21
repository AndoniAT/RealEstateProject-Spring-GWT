package com.realState.realState.user;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
	
	@GetMapping
	public List<User> getUsers() {
		return List.of(
				new User(1L, "Andoni", "Alonso", "andoniexemple@exemple.com", LocalDate.of(1996, Month.DECEMBER, 11)),
				new User(2L, "Maria", "Tort", "mariaexemple@exemple.com", LocalDate.of(2000, Month.FEBRUARY, 20))
				);
	}

}
