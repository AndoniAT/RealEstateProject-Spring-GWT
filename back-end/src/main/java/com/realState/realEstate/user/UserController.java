package com.realState.realEstate.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.realState.realEstate.Estate.Estate;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<Map<String, Object>> getUsers() {
		List<UserApp> users = this.userService.getUsers();
	    return users.stream()
	        .map(user -> {
	        	Map<String, Object> response = new HashMap<>();
	    	    response.put("id", user.getId() );
	    	    response.put("firstname", user.getFirstname());
	    	    response.put("lastname", user.getLastname());
	    	    response.put("email", user.getEmail());
	    	    response.put("dob", user.getDob());
	    	    
	    	    List<Estate> estates = user.getEstatesList();
	    	    List<Long> estates_ids = estates.stream().map( est -> est.getId() ).collect(Collectors.toList());
	    	    response.put("Estates", estates_ids);
	    	    return response;
	        } 
	        ).collect(Collectors.toList());
	}
	
	@PostMapping
	public void postUser(@RequestBody UserApp user) {
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
