package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Customers;
import com.app.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customers> getAllCustomers() {
		
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(value = "/customers/{cid}", method = RequestMethod.GET)
	public Customers getCustomer(@PathVariable int cid) {
		
		return customerService.getCustomer(cid);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customers customer) {
		
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(value = "/customers/{cid}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable int cid) {
		
		customerService.deleteCustomer(cid);
	}
}
