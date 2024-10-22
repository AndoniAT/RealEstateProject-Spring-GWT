package com.realState.realEstate.Estate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realState.realEstate.user.UserApp;
import com.realState.realEstate.user.UserRepository;

@Service
public class EstateService {
	private final EstateRepository estateRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public EstateService(EstateRepository estateRepository, UserRepository userRepository) {
		this.estateRepository = estateRepository;
		this.userRepository = userRepository;
	}


	public List<Estate> getEstates() {
		return this.estateRepository.findAll();
	}


	public void deleteEstate(Long id) {
		Optional<Estate> estate = this.estateRepository.findById(id);
		if(!estate.isPresent()) {
			throw new IllegalStateException("Estate with Id: " + id + " does not exists" );
		}
		
		/*UserApp user = estate.get().getOwner();
		List<Estate> = user.getEstatesList();*/
		
		this.estateRepository.deleteById(id);
	}


	public void addEstate(Estate estate) {
		Optional<UserApp> userOptional = this.userRepository.findUserByEmail(estate.getOwner().getEmail());

		if(!userOptional.isPresent()) {
			throw new IllegalStateException("User does not exists");
		}
		System.out.println("Check user");
		System.out.println(userOptional.get());
		UserApp user = userOptional.get();
		List<Estate> estates_user = new ArrayList<>();
		estate.setOwner(user);
		
		user.getEstatesList().forEach( es -> {
			estates_user.add(es);
		});
		estates_user.add(estate);
		user.setEstatesList(estates_user);
		userRepository.save(user);
		//this.estateRepository.save(estate);
		
	}

}
