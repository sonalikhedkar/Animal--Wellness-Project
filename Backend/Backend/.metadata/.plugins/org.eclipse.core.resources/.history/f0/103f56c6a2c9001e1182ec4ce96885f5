package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.IProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	IProductService service ;
		
	@GetMapping
	public List<Product> getAllProduct(){
		return service.fetchAllProducts();
	}

	@GetMapping("details/{productId}")
	public Product detailsParticularProduct(@PathVariable int productId) {
		return service.getProductById(productId) ;
	}
	
	@GetMapping("/category/Table")
	public List<Product> getTableProducts(){
		return service.findByCategoryTable();
	}
	
	@GetMapping("/category/Sofa")
	public List<Product> getSofaProducts(){
		return service.findByCategorySofa();
	}
	
	@GetMapping("/category/Chair")
	public List<Product> getChairProducts(){
		return service.findByCategoryChair();
	}
		
}
