package com.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Cart;
import com.app.models.Items;
import com.app.models.Orders;
import com.app.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService  {
	
	int dummy = 11111111;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartService cartService;
	
	private Orders order;
	
	@Override
	public boolean confirmOrder(Cart cart) {
		order = new Orders();
		order.setCustomer(cart.getCustomer());
		order.setOrddate(new Date());
		order.setTransactionNumber(dummy);
		order.setOrderedItems(cart.getSelectedItems());
		
		int totalAmount = 0;
		for(Items item : cart.getSelectedItems()) {
			totalAmount += item.getTotalPrice();
		}		
		order.setTotalAmount(totalAmount);
		
		orderRepository.save(order);
		
		//Empty the cart after placing the order
		cartService.emptyCart(cart.getCustomer().getCid());
		
		return true;
	}

	@Override
	public List<Orders> getOrdersByCutomer(int cid) {
		
		List<Orders> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		List<Orders> myOrders = new ArrayList<>();
		for(Orders order : orders) {
			
			if(cid == order.getCustomer().getCid()) {
				myOrders.add(order);
			}
		}
		
		//orderRepository.findByCustomerCid(cid).forEach(orders::add);
		
		
		return myOrders;
	}
	
	
	

}
