package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.excepe.UserHandlingException;
import com.app.dto.Login;
import com.app.entities.Customer;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
		@Autowired
		IUserService userService ;

		@PostMapping("/user-add")
		public  String saveUser(@RequestBody Customer customer){
			return userService.saveUser(customer);
		}
		
		@PostMapping("/customer")
		public  ResponseEntity<?> login(@RequestBody Login login) {
			Customer cust = userService.loginAsACustomer(login) ;
			if(cust instanceof Customer) {
				return ResponseEntity.ok(cust);
				
			}else
				throw new UserHandlingException("Customer Not Found");
		}			
		
}
