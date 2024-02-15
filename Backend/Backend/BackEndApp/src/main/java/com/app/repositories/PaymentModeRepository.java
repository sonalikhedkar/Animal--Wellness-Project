package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.PaymentMode;

public interface PaymentModeRepository extends JpaRepository<PaymentMode,Integer>{
	
	
}
