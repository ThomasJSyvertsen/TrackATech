package tracker.beans;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS152 - Fall 2021 Dec 8, 2021
 */

@Entity
public class Technician {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String phoneNumber;

	/**
	 * 
	 */
	public Technician() {
		super();
	}

	/**
	 * @param name
	 * @param phoneNumber
	 */
	public Technician(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
