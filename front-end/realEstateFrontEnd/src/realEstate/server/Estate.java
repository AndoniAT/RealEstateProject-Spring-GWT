package realEstate.server;

public class Estate {
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
	private String address;
	private UserApp owner;

	public Estate(double price, String country, String city, String cp, int number, String street, int surface,
			String title, String description, String address, UserApp owner) {
		super();
		this.price = price;
		this.country = country;
		this.city = city;
		this.cp = cp;
		this.number = number;
		this.street = street;
		this.surface = surface;
		this.title = title;
		this.description = description;
		this.address = address;
		this.owner = owner;
	}
	
	public Estate(Long id, double price, String country, String city, String cp, int number, String street, int surface,
			String title, String description, String address, UserApp owner) {
		super();
		this.id = id;
		this.price = price;
		this.country = country;
		this.city = city;
		this.cp = cp;
		this.number = number;
		this.street = street;
		this.surface = surface;
		this.title = title;
		this.description = description;
		this.address = address;
		this.owner = owner;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserApp getOwner() {
		return owner;
	}

	public void setOwner(UserApp owner) {
		this.owner = owner;
	}
	
	
	
	
}
