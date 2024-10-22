package com.realState.realEstate.Estate;

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
	private String cp;
	private int number;
	private String street;
	private int surface;
	
	@Transient
	private String address;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
	private UserApp owner;
	
	public Estate() {
	}

	public Estate(double price, String country, String cp, int number, String street, int surface) {
		this.price = price;
		this.country = country;
		this.cp = cp;
		this.number = number;
		this.street = street;
		this.surface = surface;
	}
	
	public Estate(Long id, double price, String country, String cp, int number, String street, int surface) {
		this.id = id;
		this.price = price;
		this.country = country;
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
		return this.number + ", " + this.street + "" + this.cp + ", " + this.country;
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
}
