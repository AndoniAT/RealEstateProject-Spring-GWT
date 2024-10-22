package realEstate.shared;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserApp implements Serializable {
	private Long id; // Id is a sequence generated one by one
	private String firstname;
	private String lastname;
	private String email;
	private Date dob;

	public UserApp() {
	}
	
	public UserApp(Long id, String firstname, String lastname, String email, Date dob ) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
	}
	
	public UserApp(String firstname, String lastname, String email, Date dob ) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
    
}
