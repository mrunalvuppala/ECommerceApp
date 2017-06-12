package com.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.models.Items;
import com.app.models.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

	//public Orders findByCustomerCid(int cid);
	
	//public Orders findByCustomerCid(int cid);

}
