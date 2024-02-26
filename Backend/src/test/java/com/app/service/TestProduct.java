package com.app.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entities.Product;

@SpringBootTest
class TestProduct {

//	make d i 
	@Autowired
	IProductService productService ;
	
	@Test
	void checkProductIsAvailable() {
			Product product 	= productService.getProductById(1) ;
//			assertTrue(product != null);
	}
	
	@Test
	void checkProductList() {
		List<Product> products = productService.fetchAllProducts();
//		assertTrue(products.size() == 6);
	}
	
	
}
