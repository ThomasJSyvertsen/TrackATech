package tracker.beans;

import java.util.LinkedList;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS175 - Fall 2021
 * Dec 9, 2021
 */
public class Tracker {
	private LinkedList<Technician> techList;

	/**
	 * @param techList
	 */
	public Tracker() {
		super();
	}
	
	public void add(Technician tech) {
		techList.add(tech);
	}
	
	public void sort() {
		for(int i = 0; i < techList.size(); i++) {
			
		}
	}

	/**
	 * @return the techList
	 */
	public LinkedList<Technician> getTechList() {
		return techList;
	}

	/**
	 * @param techList the techList to set
	 */
	public void setTechList(LinkedList<Technician> techList) {
		this.techList = techList;
	}	
}
