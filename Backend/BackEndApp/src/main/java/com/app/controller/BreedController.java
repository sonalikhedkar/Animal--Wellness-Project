package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Breed;
import com.app.service.EmailSenderService;
import com.app.service.IBreedService;



@RestController
@RequestMapping("/breed")
@CrossOrigin(origins = "http://localhost:3000")
public class BreedController {

	@Autowired
	EmailSenderService emailSenderService;
	
	@Autowired
	private IBreedService breedService;
	

	@GetMapping("/breeds")
	public List<Breed> getAllUsers(){
		return breedService.fetchAllBreeds();
	}
	
	@PostMapping("/breed-add")
	public ResponseEntity<?> saveUser(@RequestBody Breed user) {
		return new ResponseEntity<>(breedService.saveBreedDetails(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int userId){
		return ResponseEntity.ok(breedService.deleteBreedDetails(userId));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int id){
		return ResponseEntity.ok(breedService.getBreedDetails(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int id,@RequestBody Breed detachedUser){
		return ResponseEntity.ok(breedService.updateBreedDetails(detachedUser));
	}
	
	
}

