package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Customers;
import com.app.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customers> getAllCustomers() {
		
		List<Customers> customers = new ArrayList<>();
		customerRepository.findAll()
							.forEach(customers::add);
		return customers;
	}
	
	@Override
	public Customers getCustomer(int cid) {
		
		return customerRepository.findOne(cid);
	}

	@Override
	public void addCustomer(Customers customer) {
		
		customerRepository.save(customer);
	}
	
	
	@Override
	public void deleteCustomer(int cid) {
		
		customerRepository.delete(cid);
	}	
}
