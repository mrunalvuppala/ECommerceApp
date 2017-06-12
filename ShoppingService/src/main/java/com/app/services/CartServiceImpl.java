package com.app.services;

import javax.persistence.ElementCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Cart;
import com.app.models.Customers;
import com.app.models.Items;
import com.app.models.Products;
import com.app.repositories.CartRepository;
import com.app.repositories.CustomerRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	//@Autowired
	private Items item = new Items();

	//@Autowired
	private Cart cart;// = new Cart();;
	
	private int x = 0;

	@Override	// To get the cart and list of items in it
	public Cart getCart(int custId) {
		
		return cartRepository.findByCustomerCid(custId);
	}
	
	@Override	
	public boolean addProductToCart(int pid, int cid, int quantity) {
		
		cart = getCart(cid);
		
		if(cart == null) {	// If there is no cart for a customer
			cart = new Cart();

			if(customerService.getCustomer(cid)!=null) { // Setting the customer to the cart			
			cart.setCustomer(customerService.getCustomer(cid));
			} 
			else {
				return false;
			}
		}
		for(Items item : cart.getSelectedItems()) {	// If the same customer wants to add more quantity for the same 
			if(pid == item.getPid()) {					// products that he selected already.
			
				x = item.getQuantity();
				x += quantity;
				item.setQuantity(x);
				item.setTotalPrice(item.getpPrice()*item.getQuantity());
				cart.getSelectedItems().add(item);
				cartRepository.save(cart);
				return true;				
			}
		}
		
		item.setPid(pid);
		item.setpName(productService.getProduct(pid).getpName());
		item.setpPrice(productService.getProduct(pid).getpPrice());
		item.setQuantity(quantity);
		item.setTotalPrice(item.getpPrice()*item.getQuantity());
		cart.getSelectedItems().add(item);
		cartRepository.save(cart);
		return true;
	}

	@Override
	public boolean deleteProduct(int pid, int cid) {
		
		cart = getCart(cid);		
		
		for(Items item : cart.getSelectedItems()) {
			if(pid == item.getPid()) {
				cart.getSelectedItems().remove(item);
				cartRepository.save(cart);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean emptyCart(int cid) {
		
		if(cartRepository.findByCustomerCid(cid) != null) {		
		cartRepository.delete(cartRepository.findByCustomerCid(cid).getCaid());
		return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateQuantity(int quantity, int cid, int pid) {

		cart = getCart(cid);
		for(Items item : cart.getSelectedItems()) {
			
			if(pid == item.getPid()) {
			item.setQuantity(quantity);
			cart.getSelectedItems().add(item);
			cartRepository.save(cart);
			return true;
			}
		}
		return false;
	}
}