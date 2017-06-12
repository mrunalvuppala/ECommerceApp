package com.app.services;

import com.app.models.Cart;
import com.app.models.Customers;
import com.app.models.Products;

public interface CartService {

	public Cart getCart(int custId);
	
	public boolean addProductToCart(int pid, int cid, int quantity);
	
	public boolean deleteProduct(int pid, int cid);
	
	public boolean emptyCart(int l);
	
	public boolean updateQuantity(int quantity, int cid, int pid);
	
}

