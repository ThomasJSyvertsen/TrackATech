package tracker.beans;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS152 - Fall 2021 Dec 8, 2021
 */
public class Technician {
	private String name;
	private double phoneNumber;
	private LinkedList<Order> orders;
	private ArrayList<String> cities;

	/**
	 * @param name
	 * @param phoneNumber
	 */
	public Technician(String name, double phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.cities = new ArrayList<String>();
		this.orders = new LinkedList<Order>();
	}
	
	public boolean add(Order order) {
		if (orders.isEmpty() || !cities.contains(order.getCustomer().getLocation().getCity())) {
			orders.add(order);
			cities.add(order.getCustomer().getLocation().getCity());
			return true;
		}

		boolean cityFound = false;

		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getCustomer().getLocation().getCity() == order.getCustomer().getLocation().getCity()) {
				cityFound = true;
			} else if (cityFound && orders.get(i).getCustomer().getLocation().getCity() != order.getCustomer().getLocation()
					.getCity()) {
				orders.add(i, order);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean offer(Order order) {
		return add(order);
	}

	public Order peek() {
		if (orders.isEmpty()) {
			return null;
		}
		return orders.get(0);
	}
	
	public Order element() {
		return peek();
	}

	public Order poll() {
		if (orders.isEmpty()) {
			return null;
		}

		return orders.getFirst();
	}
	
	public Order remove() {
		return poll();
	}

	public boolean isEmpty() {
		return orders.get(0) == null;
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
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < orders.size(); i++) {
			toReturn += orders.get(i).toString() + "\n";
		}
		return toReturn;
	}
}
