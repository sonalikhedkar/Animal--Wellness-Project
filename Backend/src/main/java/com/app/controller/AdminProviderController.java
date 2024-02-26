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

import com.app.dto.Login;
import com.app.entities.Customer;
import com.app.entities.Provider;
import com.app.excepe.UserHandlingException;
import com.app.service.EmailSenderService;
import com.app.service.IAdminProviderService;


@RestController
@RequestMapping("/provider")
@CrossOrigin(origins = "*")
public class AdminProviderController {

	@Autowired
	EmailSenderService emailSenderService;
	
	@Autowired
	private IAdminProviderService adminProviderService;
	

	@GetMapping("/providers")
	public List<Provider> getAllUsers(){
		return adminProviderService.fetchAllUsers();
	}
	
	@PostMapping("/provider-add")
	public ResponseEntity<?> saveUser(@RequestBody Provider user) {
		return new ResponseEntity<>(adminProviderService.saveProviderDetails(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int userId){
		return ResponseEntity.ok(adminProviderService.deleteProviderDetails(userId));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int id){
		return ResponseEntity.ok(adminProviderService.getProviderDetails(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int id,@RequestBody Provider detachedUser){
		return ResponseEntity.ok(adminProviderService.updateProviderDetails(detachedUser));
	}
	
	@PostMapping("/verify-provider")
	public  ResponseEntity<?> login(@RequestBody Login login) {
		Provider pro = adminProviderService.loginAsAProvider(login) ;
		if(pro instanceof Provider) {
			return ResponseEntity.ok(pro);
			
		}else
			throw new UserHandlingException("Provider Not Found");
	}
	
	@GetMapping("/get-password/{email}")
	public ResponseEntity<?> getUserPassword(@PathVariable String email){
		Provider cust=adminProviderService.getProviderByEmail(email);
		if(cust==null) {
			return ResponseEntity.ok("Provider with this email doesnt exist");
		}
		else {
		String userPassword=cust.getPassword();
		emailSenderService.sendSimpleEmail(email, "Your password for peteria is "+userPassword, "Peteria login password");
		return ResponseEntity.ok("password has sent to your email");
		}
	}
	
}

