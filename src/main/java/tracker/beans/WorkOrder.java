package tracker.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS152 - Fall 2021 Dec 8, 2021
 */

@Entity
public class WorkOrder {
	@Id
	@GeneratedValue
	private long id;
	@Autowired
	private Customer customer;
	//This will indicate the 1-12 time.
	private int time;
	//This will indicate if the appointment is in the morning or evening.
	//true if in morning, false if in evening.
	private boolean morning;

	/**
	 * 
	 */
	public WorkOrder() {
		super();
	}

	/**
	 * @param technician
	 * @param customer
	 */
	public WorkOrder(Customer customer, int time, boolean morning) {
		super();
		this.customer = customer;
		this.time = time;
		this.morning = morning;
	}
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return the morning
	 */
	public boolean isMorning() {
		return morning;
	}

	/**
	 * @param morning the morning to set
	 */
	public void setMorning(boolean morning) {
		this.morning = morning;
	}
	
	public void setCity(String city) {
		this.customer.setCity(city);
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", time=" + time + ", morning=" + morning + "]";
	}
}