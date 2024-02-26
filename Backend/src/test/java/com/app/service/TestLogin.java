package com.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dto.Login;
import com.app.entities.Customer;

@SpringBootTest
class TestLogin {

	@Autowired
	IUserService userService ;
	
	@Test
	void testLogin() {
		Login currentLogin = new Login("t@gmail.com", "123456", null) ;
		Customer cust = userService.loginAsACustomer(currentLogin) ;
//		assertTrue(currentLogin.getEmail().equals(cust.getEmail()));
	}

}
