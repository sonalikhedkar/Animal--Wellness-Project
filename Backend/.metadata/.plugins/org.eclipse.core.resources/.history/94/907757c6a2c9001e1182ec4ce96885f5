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

import com.app.entities.Vet;
import com.app.service.IVetService;



@RestController 
@RequestMapping("/vet")
@CrossOrigin(origins = "http://localhost:3000")
public class VetController {

	@Autowired
	private IVetService vetService;
	
	@GetMapping("/vets")
	public List<Vet> getAllVets(){
		return vetService.fetchAllVets();
	}
	
	@PostMapping("/vet-add")
	public ResponseEntity<?> saveProduct(@RequestBody Vet vet) {
		return new ResponseEntity<>(vetService.saveVetDetails(vet), HttpStatus.CREATED);
	}
	
    @DeleteMapping("/vet/{vetId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable int productId){
		return ResponseEntity.ok(vetService.deleteVetDetails(productId));
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductDetails(@PathVariable int id){
		return ResponseEntity.ok(vetService.getVetDetails(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProductDetails(@PathVariable int id,@RequestBody Vet detachedProduct){	
		return ResponseEntity.ok(vetService.updateVetDetails(detachedProduct));
	}
	
}
