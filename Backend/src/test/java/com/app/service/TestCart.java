package com.app.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entities.Product;

@SpringBootTest
class TestCart {

	@Autowired
	CartService cartService ;
	
	@Test
	void testAddToCart() {
		String actual = "Added To Cart";
		String real = cartService.addProductToCart(1, 1);	
		assertTrue(actual.equals(real));
	}
	
	@Test
	void testListOfProcuct() {
		List<Product> products = cartService.getAllItemsByCart(1);
		int size = products.size();
	}

}
