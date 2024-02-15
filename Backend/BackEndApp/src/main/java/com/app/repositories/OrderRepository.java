package com.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

	Order findByCustomerId(int custmerId);
	void deleteByCustomerId(int customerId);
}
