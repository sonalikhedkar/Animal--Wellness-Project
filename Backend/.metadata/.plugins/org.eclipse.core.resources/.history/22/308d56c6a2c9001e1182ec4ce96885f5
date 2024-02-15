package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Login;
import com.app.entities.User;
import com.app.excepe.UserHandlingException;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	@PostMapping
	public  ResponseEntity<?> login(@RequestBody Login login) {
		User admin = adminService.loginAsAdmin(login) ;
		if(admin instanceof User) {
			return ResponseEntity.ok(admin);
			
		}else
			throw new UserHandlingException("Admin Not Found");
	}	
}
