package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.app.entities.Breed;

public interface IPetCartService {

	

	List<Breed> getAllItemsByCart(int customerId);

	String addPetToByCart(int customerId, int petId);

	

	
}
