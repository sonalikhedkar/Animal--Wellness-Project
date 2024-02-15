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

import com.app.dto.AdminProduct;
import com.app.entities.Product;
import com.app.service.IAdminProductService;

@RestController 
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminProductController {

	@Autowired
	private IAdminProductService adminProductService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return adminProductService.fetchAllProducts();
	}
	
	@PostMapping("/product-add")
	public ResponseEntity<?> saveProduct(@RequestBody AdminProduct product) {
		return new ResponseEntity<>(adminProductService.saveProductDetails(product), HttpStatus.CREATED);
	}
	
    @DeleteMapping("/product/{productId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable int productId){
		return ResponseEntity.ok(adminProductService.deleteProductDetails(productId));
	}
    
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductDetails(@PathVariable int id){
		return ResponseEntity.ok(adminProductService.getProductDetails(id));
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<?> updateProductDetails(@PathVariable int id,@RequestBody Product detachedProduct){	
		return ResponseEntity.ok(adminProductService.updateProductDetails(detachedProduct));
	}
	
}
