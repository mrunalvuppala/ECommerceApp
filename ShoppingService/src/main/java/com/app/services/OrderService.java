package com.app.services;

import java.util.List;

import com.app.models.Cart;
import com.app.models.Orders;

public interface OrderService {
	
	
	public boolean confirmOrder(Cart cart);
	
	public List<Orders> getOrdersByCutomer(int cid);

}
