package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;


public interface AdminUserRepository extends JpaRepository<Customer, Integer>{
	Customer getByCartId(int cartId);
	Customer getByEmail(String email);
}
