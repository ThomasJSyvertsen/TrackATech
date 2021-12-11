package tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tracker.beans.Customer;
import tracker.beans.Location;
import tracker.beans.Technician;
import tracker.beans.WorkOrder;
import tracker.beans.WorkOrderTracker;
import tracker.repository.TechnicianRepository;
import tracker.repository.WorkOrderRepository;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS152 - Fall 2021 Dec 10, 2021
 */

@Controller
public class WebController {
	@Autowired
	WorkOrderRepository workOrderRepo;
	@Autowired
	TechnicianRepository techRepo;
	@Autowired
	WorkOrderTracker workOrderTracker = new WorkOrderTracker();
	@Autowired
	Technician tech = new Technician();
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
	@PostMapping("/home") 
	public String homePost(Model model) {
		WorkOrder workOrder = workOrderTracker.poll();
		model.addAttribute("workOrder", workOrder.toString());
		return "HomeNew";
	}
	
	@GetMapping("/viewAllWorkOrders")
	public String viewAllWorkOrders(Model model) {
		model.addAttribute("workOrders", workOrderRepo.findAll());
		return "workOrderResults";
	}
	
	@GetMapping("/viewWorkOrder/{id}")
	public String viewWorkOrder(@PathVariable("id") long id, Model model) {
		WorkOrder workOrder = workOrderRepo.findById(id).orElse(null);
		model.addAttribute("workOrder", workOrder);
		model.addAttribute("customer", workOrder.getCustomer());
		model.addAttribute("id", workOrder.getId());
		return "workOrderView";
	}
	
	@GetMapping("/inputWorkOrder")
	public String addNewWorkOrder(Model model) {
		WorkOrder workOrder = new WorkOrder();
		model.addAttribute("newWorkOrder", workOrder);
		return "workOrderInput";
	}
	
	@PostMapping("/inputWorkOrder")
	public String addNewWorkOrder(@ModelAttribute WorkOrder workOrder, Model model) {
		Customer cust = new Customer();
		Location loc = new Location();
		cust.setLocation(loc);
		workOrder.setCustomer(cust);
		workOrderRepo.save(workOrder);
		return viewAllWorkOrders(model);
	}
	
	@GetMapping("/viewCustomerLocation/{id}")
	public String viewLocation(@PathVariable("id") long id, Model model) {
		WorkOrder workOrder = workOrderRepo.findById(id).orElse(null);
		Customer cust = workOrder.getCustomer();
		cust.setCustomerId(workOrder.getId());
		model.addAttribute("workOrder", workOrder);
		model.addAttribute("location", cust.getLocation());
		model.addAttribute("id", id);
		return "locationResults";
	}
	
	@GetMapping("/inputLocation/{id}")
	public String addNewLocation(@PathVariable("id") long id, Model model) {
		WorkOrder workOrder = workOrderRepo.findById(id).orElse(null);
		Location loc = new Location();
		model.addAttribute("id", workOrder.getId());
		model.addAttribute("newLocation", loc);
		return "locationInput";
	}
	
	@PostMapping("/inputLocation/{id}")
	public String addNewLocation(@PathVariable("id") long id, @ModelAttribute Location loc, Model model) {
		WorkOrder workOrder = workOrderRepo.findById(id).orElse(null);
		Customer cust = workOrder.getCustomer();
		cust.setLocation(loc);
		workOrder.setCustomer(cust);
		workOrderRepo.save(workOrder);	
		workOrderTracker.add(workOrder);
		return viewLocation(id, model);
	}
	
	@GetMapping("/viewCustomer/{id}")
	public String viewCustomer(@PathVariable("id") long id, Model model) {
		WorkOrder workOrder = workOrderRepo.findById(id).orElse(null);
		model.addAttribute("workOrder", workOrder);
		model.addAttribute("customer", workOrder.getCustomer());
		model.addAttribute("id", id);
		return "customerResults";
	}

	@GetMapping("/inputCustomer/{id}")
	public String addNewCustomer(@PathVariable("id") long id, Model model) {
		WorkOrder workOrder = workOrderRepo.findById(id).orElse(null);
		Customer cust = new Customer();
		model.addAttribute("newCustomer", cust);
		model.addAttribute("workOrder", workOrder);
		return "customerInput";
	}
	
	@PostMapping("/inputCustomer/{id}")
	public String addNewCustomer(@PathVariable("id") long id, @ModelAttribute Customer cust, Model model) {
		WorkOrder workOrder = workOrderRepo.findById(id).orElse(null);
		Location loc = new Location();
		cust.setLocation(loc);
		workOrder.setCustomer(cust);
		workOrderRepo.save(workOrder);		
		return viewCustomer(id, model);
	}

	@GetMapping("/viewAllTechs")
	public String viewAllTechs(Model model) {
		model.addAttribute("techs", techRepo.findAll());
		return "techResults";
	}

	@GetMapping("/inputTech")
	public String addNewTech(Model model) {
		Technician tech = new Technician();
		model.addAttribute("newTech", tech);
		return "techInput";
	}

	@PostMapping("/inputTech")
	public String addNewTech(@ModelAttribute Technician tech, Model model) {
		techRepo.save(tech);
		return viewAllTechs(model);
	}
}
