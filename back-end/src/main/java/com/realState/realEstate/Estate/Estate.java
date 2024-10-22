package com.realState.realEstate.Estate;

import java.util.HashMap;
import java.util.Map;

import com.realState.realEstate.user.UserApp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Estate {
	@Id
	@SequenceGenerator(
			name = "estate_sequence",
			sequenceName = "estate_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "estate_sequence"
			)
	private Long id; // Id is a sequence generated one by one
	private double price;
	
	private String country;
	private String city;
	private String cp;
	private int number;
	private String street;
	private int surface;
	private String title;
	private String description;
	
	@Transient
	private String address;
	
	@ManyToOne
    @JoinColumn(name = "owner_id")
	private UserApp owner;
	
	public Estate() {
	}

	public Estate(String title, String description, double price, String country, String city, String cp, int number, String street, int surface) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.country = country;
		this.city = city;
		this.cp = cp;
		this.number = number;
		this.street = street;
		this.surface = surface;
	}
	
	public Estate(String title, String description, Long id, double price, String country, String city, String cp, int number, String street, int surface) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.country = country;
		this.city = city;
		this.cp = cp;
		this.number = number;
		this.street = street;
		this.surface = surface;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public UserApp getOwner() {
		return owner;
	}

	public void setOwner(UserApp owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return this.number + ", " + this.street + "" + this.cp + ", " + this.city + " " + this.country;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Map<String, Object> toJson() {
		Estate estate = this;
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
	
	
	
	
}
