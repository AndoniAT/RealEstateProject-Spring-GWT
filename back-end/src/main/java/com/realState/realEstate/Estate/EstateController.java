package com.realState.realEstate.Estate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = {"http://127.0.0.1:8888", "http://127.0.0.1:9876"})
public class EstateController {
	private final EstateService estateService;
	
	@Autowired
	public EstateController(EstateService estateService) {
		this.estateService = estateService;
	}
	
	@GetMapping
	public List<Map<String, Object>> getEstates() {
		List<Estate> estates = this.estateService.getEstates();
	    return estates.stream().map(estate -> estate.toJson() ).collect(Collectors.toList());
	}
	
	@GetMapping(path = "{estateId}")
	public Map<String, Object> getEstate(@PathVariable("estateId") Long id){
		Estate estate = this.estateService.getEstate(id);
	    return estate.toJson();
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
