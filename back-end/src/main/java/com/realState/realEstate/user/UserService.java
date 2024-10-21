package com.realState.realEstate.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	// We use the setters methods in the UserApp class to update the object
	@Transactional
	public void updateUser(Long userId, String firstname, String lastname, String email) {
		UserApp usr = this.userRepository.findById(userId)
		.orElseThrow(() -> new IllegalStateException( "User with Id: " + userId + " does not exists"  ));
		
		if( firstname != null && firstname.length() > 0 && !Objects.equals(usr.getFirstname(), firstname) ) {
			usr.setFirstname(firstname);
		}
		
		if( lastname != null && lastname.length() > 0 && !Objects.equals(usr.getLastname(), lastname) ) {
			usr.setLastname(lastname);
		}

		if( email != null && email.length() > 0 && !Objects.equals(usr.getEmail(), email) ) {
			Optional<UserApp> optionalUser = this.userRepository.findUserByEmail(email);
			if(optionalUser.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
		
		usr.setEmail(email);
		}
		
	}

	public void deleteUser(Long id) {
		boolean exists = this.userRepository.existsById(id);
		if( !exists  ) {
			throw new IllegalStateException("User with Id: " + id + " does not exists" );
		}
		
		this.userRepository.deleteById(id);
	}
}
