package com.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment,Integer>{
		Payment findByOrderId(int orderId) ;
		void deleteByOrderId(int orderId);
}
