package com.realState.realEstate.Estate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realState.realEstate.user.UserApp;

@RestController
@RequestMapping(path = "api/estates")
public class EstateController {
	private final EstateService estateService;
	
	@Autowired
	public EstateController(EstateService estateService) {
		this.estateService = estateService;
	}
	
	@GetMapping
	public List<Map<String, Object>> getEstates() {
		List<Estate> estates = this.estateService.getEstates();
	    return estates.stream()
	        .map(estate -> {
	        	Map<String, Object> response = new HashMap<>();
	    	    response.put("id", estate.getId() );
	    	    response.put("title", estate.getTitle() );
	    	    response.put("description", estate.getDescription() );
	    	    response.put("price", estate.getPrice());
	    	    response.put("address", estate.getAddress());
	    	    response.put("owner", estate.getOwner().getEmail());
	    	    response.put("surface", estate.getSurface());
	    	    return response;
	        } 
	        ).collect(Collectors.toList());
	}
	
	@PostMapping
	public void postEstate(@RequestBody Estate estate) {
		this.estateService.addEstate(estate);
	}
	
	@DeleteMapping(path = "{estateId}")
	public void deleteEstate(@PathVariable("estateId") Long id){
		this.estateService.deleteEstate(id);
	}
}
