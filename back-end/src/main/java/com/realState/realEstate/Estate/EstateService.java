package com.realState.realEstate.Estate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realState.realEstate.user.UserApp;

@Service
public class EstateService {
	private final EstateRepository estateRepository;
	
	@Autowired
	public EstateService(EstateRepository estateRepository) {
		this.estateRepository = estateRepository;
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

}
