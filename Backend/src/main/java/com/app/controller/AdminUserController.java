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

import com.app.entities.Customer;
import com.app.service.EmailSenderService;
import com.app.service.IAdminUserService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminUserController {

	@Autowired
	EmailSenderService emailSenderService;
	
	@Autowired
	private IAdminUserService adminUserService;
	

	@GetMapping("/users")
	public List<Customer> getAllUsers(){
		return adminUserService.fetchAllUsers();
	}
	
	@PostMapping("/user-add")
	public ResponseEntity<?> saveUser(@RequestBody Customer user) {
		return new ResponseEntity<>(adminUserService.saveUserDetails(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int userId){
		return ResponseEntity.ok(adminUserService.deleteUserDetails(userId));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int id){
		return ResponseEntity.ok(adminUserService.getUserDetails(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int id,@RequestBody Customer detachedUser){
		return ResponseEntity.ok(adminUserService.updateUserDetails(detachedUser));
	}
	

	
	@GetMapping("/get-password/{email}")
	public ResponseEntity<?> getUserPassword(@PathVariable String email){
		Customer cust=adminUserService.getUserByEmail(email);
		if(cust==null) {
			return ResponseEntity.ok("customer with this email doesnt exist");
		}
		else {
		String userPassword=cust.getPassword();
		emailSenderService.sendSimpleEmail(email, "your password for peteria is "+userPassword, "Peteria Login password");
		return ResponseEntity.ok("password has sent to your email " +email);
		}
	}
	
}

