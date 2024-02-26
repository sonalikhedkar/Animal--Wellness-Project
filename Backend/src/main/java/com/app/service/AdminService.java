package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.Login;
import com.app.entities.User;
import com.app.repositories.AdminRepository;
@Service
@Transactional
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public User loginAsAdmin(Login login) {
		User admin = adminRepo.findByEmail(login.getEmail()) ;
		
		if(admin.getPassword().equals(login.getPassword()) ) {
			return admin ;
		}
		return null;
	}

}
