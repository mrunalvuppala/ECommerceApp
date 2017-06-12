package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Cart;
import com.app.models.Orders;
import com.app.services.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public boolean confirmOrder(@RequestBody Cart cart) {
		System.out.println("Succ");
		orderService.confirmOrder(cart);
		return true;
	}
	
	@RequestMapping(value= "/getMyOrders/{cid}", method = RequestMethod.GET)
	public List<Orders> getOrdersByCutomer(@PathVariable int cid) {
		
		return orderService.getOrdersByCutomer(cid);
	}

}
