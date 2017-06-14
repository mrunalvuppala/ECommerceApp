package com.app.services;

import java.util.ArrayList;

import java.util.List;

import com.app.models.Cart;
import com.app.models.Customers;

public interface CustomerService {
	
	public List<Customers> getAllCustomers();
	
	public Customers getCustomer(int cid);

	public void addCustomer(Customers customer);
	
	public void deleteCustomer(int cid);

	public void updateCustomer(Customers customers);

	Customers getCustomerByName(String username);

	public List<Cart> getCart(String username);

	



}
