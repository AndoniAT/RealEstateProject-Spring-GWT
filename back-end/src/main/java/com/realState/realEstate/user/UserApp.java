package com.realState.realEstate.user;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.realState.realEstate.Estate.Estate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class UserApp {
	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
			)
	private Long id; // Id is a sequence generated one by one
	private String firstname;
	private String lastname;
	private String email;
	private LocalDate dob;
	
	// Transient is because we don't want this attribute to be created in our database's table
	@Transient
	private Integer age;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Estate> estatesList;

	public UserApp() {
	}

	public UserApp(Long id, String firstname, String lastname, String email, LocalDate dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
	}

	public UserApp(String firstname, String lastname, String email, LocalDate dob) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getAge() {
		// Get the age based in the birth date
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Estate> getEstatesList() {
		return estatesList;
	}
	
	public void addEstateToList(Estate e) {
		this.estatesList.add(e);
	}

	public void setEstatesList(List<Estate> estatesList) {
		this.estatesList = estatesList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", dob="
				+ dob + ", age=" + age + "]";
	}
	
	public Map<String, Object> toJson(){
		UserApp user = this;
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
	
	
}
