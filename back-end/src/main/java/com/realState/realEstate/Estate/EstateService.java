package com.realState.realEstate.Estate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
