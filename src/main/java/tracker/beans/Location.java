package tracker.beans;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS152 - Fall 2021 Dec 8, 2021
 */
public class Location {
	private String street;
	//Designate if is a house, apartment, town home etc.
	private String type;
	//Unit number if is an apartment.
	private String unit;
	private String city;
	//The state is an enum that is in the United States.
	private State state;

	/**
	 * 
	 */
	public Location() {
		super();
	}

	/**
	 * @param street
	 * @param type
	 * @param unit
	 * @param city
	 * @param state
	 */
	public Location(String street, String type, String unit, String city, State state) {
		super();
		this.street = street;
		this.type = type;
		this.unit = unit;
		this.city = city;
		this.state = state;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Location [street=" + street + ", type=" + type + ", unit=" + unit + ", city=" + city + ", state="
				+ state + "]";
	}
}
