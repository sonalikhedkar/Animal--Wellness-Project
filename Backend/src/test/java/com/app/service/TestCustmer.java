package com.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entities.Customer;
import com.app.repositories.UserRepository;

@SpringBootTest
class TestCustmer {

	@Autowired
	UserSerivce userService ;
	
	@Autowired
	UserRepository userRepo ;
	
	@Test
	void testAddCustmer() {
		Customer currentCustmer = new Customer("test1", "t1", "t", "t@gmail.com", "1234567890", true, "pune", "123456", null, null, null, null);
		String actual = userService.saveUser(currentCustmer);
		String practical = "Custmer Added Successfully";
//		assertTrue(actual.equals(practical));
		
	}
	
	@Test
	void testAddedCustmer() {
		String email = "t@gmail.com" ;
		Customer addedCust = userRepo.findByEmail(email) ;
//		assertTrue(addedCust != null);
	}

}
