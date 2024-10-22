package realEstate.server;

import java.time.LocalDate;
import java.util.List;

public class UserApp {
	private Long id; // Id is a sequence generated one by one
	private String firstname;
	private String lastname;
	private String email;
	private LocalDate dob;
    private List<Estate> estatesList;

	public UserApp(Long id, String firstname, String lastname, String email, LocalDate dob, List<Estate> estatesList) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.estatesList = estatesList;
	}
	
	public UserApp(String firstname, String lastname, String email, LocalDate dob, List<Estate> estatesList) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.estatesList = estatesList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Estate> getEstatesList() {
		return estatesList;
	}

	public void setEstatesList(List<Estate> estatesList) {
		this.estatesList = estatesList;
	}
    
}
