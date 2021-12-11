package tracker.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tracker.beans.Customer;
import tracker.beans.Location;
import tracker.beans.Technician;
import tracker.beans.WorkOrder;
import tracker.beans.WorkOrderTracker;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS175 - Fall 2021
 * Dec 10, 2021
 */

@Configuration
public class BeanConfiguration {
	
	@Bean 
	public Customer customer() {
		Customer bean = new Customer();
		return bean;
	}
	
	@Bean
	public Location location() {
		Location bean = new Location();
		return bean;
	}
	
	@Bean
	public WorkOrder workOrder() {
		WorkOrder bean = new WorkOrder();
		return bean;
	}
	
	@Bean
	public Technician technician() {
		Technician bean = new Technician();
		return bean;
	}
	
	@Bean
	public WorkOrderTracker workOrderTracker() {
		WorkOrderTracker bean = new WorkOrderTracker();
		return bean;
	}

}
