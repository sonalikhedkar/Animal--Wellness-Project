package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.entities.Trainer;

import com.app.service.ITrainerService;

@RestController
@RequestMapping("/trainer")
@CrossOrigin(origins = "*")
public class TrainerController {
	@Autowired
   ITrainerService service;
	
	@GetMapping("/trainers/")
	public List<Trainer> getAllTrainers(){
		return service.fetchAllTrainers();
	}
	@PostMapping("/trainer-add")
	public ResponseEntity<?> saveTrainer(@RequestBody Trainer trainer) {
		return new ResponseEntity<>(service.saveTrainerDetails(trainer), HttpStatus.CREATED);
	}
//	@PostMapping("/breed-add")
//	public ResponseEntity<?> saveUser(@RequestBody Breed user) {
//		return new ResponseEntity<>(breedService.saveBreedDetails(user), HttpStatus.CREATED);
//	}
	
   
	
}
