package com.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.Customer;

public interface UserRepository extends CrudRepository<Customer, Integer>{
		Customer findByEmail(String email) ;  
}
