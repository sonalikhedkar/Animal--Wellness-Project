package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Trainer;
import com.app.repositories.TrainerRepository;
@Service
public class TrainerService implements ITrainerService {
	@Autowired
	TrainerRepository repo;
	@Override
	public List<Trainer> fetchAllTrainers() {
		
		return repo.findAll();
	}
	@Override
	public String saveTrainerDetails(Trainer trainer) {
		
		return "Added sucuessfully!";
	}
	

}
