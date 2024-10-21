package com.realState.realEstate.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<UserApp> getUsers() {
		return this.userService.getUsers();
	}
	
	@PostMapping
	public void postUser(@RequestBody UserApp user) {
		System.out.println("addddd!!");
		this.userService.addUser(user);
	}
	
	@PutMapping(path = "{userId}")
	public void updateUser(
			@PathVariable("userId") Long userId,
			@RequestParam(required = false) String firstname,
			@RequestParam(required = false) String lastname,
			@RequestParam(required = false) String email
			) {
		this.userService.updateUser(userId, firstname, lastname, email);
	}
	
	@DeleteMapping(path = "{userId}")
	public void deleteUser(@PathVariable("userId") Long id){
		this.userService.deleteUser(id);
	}

}
