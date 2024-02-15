package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Provider;


public interface AdminProviderRepository extends JpaRepository<Provider, Integer>{
	Provider findByEmail(String email);
	Provider getByEmail(String email);
	
}
