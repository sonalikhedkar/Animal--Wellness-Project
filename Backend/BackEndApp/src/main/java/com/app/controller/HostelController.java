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

import com.app.entities.Hostel;
import com.app.service.IHostelService;



@RestController 
@RequestMapping("/hostel")
@CrossOrigin(origins = "http://localhost:3000")
public class HostelController {

	@Autowired
	private IHostelService hostelService;
	
	@GetMapping("/hostels")
	public List<Hostel> getAllHostels(){
		return hostelService.fetchAllHostels();
	}
	
	@PostMapping("/hostel-add")
	public ResponseEntity<?> saveProduct(@RequestBody Hostel hostel) {
		return new ResponseEntity<>(hostelService.saveHostelDetails(hostel), HttpStatus.CREATED);
	}
	
    @DeleteMapping("/hostel/{hostelId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable int productId){
		return ResponseEntity.ok(hostelService.deleteHostelDetails(productId));
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductDetails(@PathVariable int id){
		return ResponseEntity.ok(hostelService.getHostelDetails(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProductDetails(@PathVariable int id,@RequestBody Hostel detachedProduct){	
		return ResponseEntity.ok(hostelService.updateHostelDetails(detachedProduct));
	}
	
}
