package tracker.beans;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS152 - Fall 2021 Dec 8, 2021
 */
public class Customer {
	private String name;
	private double phoneNumber;
	//Each customer has a location where the job will take place.
	private Location location;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param name
	 * @param phoneNumber
	 * @param location
	 */
	public Customer(String name, double phoneNumber, Location location) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.location = location;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public double getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setCity(String city) {
		this.location.setCity(city);
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", location=" + location + "]";
	}
}
