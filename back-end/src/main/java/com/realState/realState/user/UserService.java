package com.realState.realState.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component or @Service
// is to indicate that this class has to be instanciated
//both are the same thing but service is better for the semantic here
//@Component
@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserApp> getUsers() {
		return this.userRepository.findAll();
	}

	public void addUser(UserApp user) {
		Optional<UserApp> userOptional = this.userRepository.findUserByEmail(user.getEmail());
		if(userOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		
		this.userRepository.save(user);
		System.out.println("Added : " + user);
		
	}
}
