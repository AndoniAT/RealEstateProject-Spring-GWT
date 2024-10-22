package realEstate.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Estat implements Serializable {
	private Long id;
	private String title;
	private String description;
	private double price;
	private String address;
	private int surface;
	
	private String owner;

	public Estat() {
		
	}

	public Estat(Long id, String title, String description, double price, String address, int surface, String owner) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.address = address;
		this.surface = surface;
		this.owner = owner;
	}

	public Estat(String title, String description, double price, String address, int surface, String owner) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.address = address;
		this.surface = surface;
		this.owner = owner;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}
