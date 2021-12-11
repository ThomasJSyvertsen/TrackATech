package tracker.beans;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS152 - Fall 2021
 * Dec 10, 2021
 */
public class WorkOrderTracker {
	private LinkedList<WorkOrder> orders;
	private ArrayList<String> cities;
	
	/**
	 * 
	 */
	public WorkOrderTracker() {
		super();
		this.cities = new ArrayList<String>();
		this.orders = new LinkedList<WorkOrder>();
	}
	
	/**
	 * Adds and order to the 
	 * @param order
	 * @return
	 */
	public boolean add(WorkOrder order) {
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
	
	public boolean offer(WorkOrder order) {
		return add(order);
	}

	public WorkOrder peek() {
		if (orders.isEmpty()) {
			return null;
		}
		return orders.get(0);
	}
	
	public WorkOrder element() {
		return peek();
	}

	public WorkOrder poll() {
		if (orders.isEmpty()) {
			return null;
		}

		return orders.getFirst();
	}
	
	public WorkOrder remove() {
		return poll();
	}

	public boolean isEmpty() {
		return orders.get(0) == null;
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