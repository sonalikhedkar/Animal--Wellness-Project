package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Customer;
import com.app.entities.Order;
import com.app.excepe.UserHandlingException;
import com.app.repositories.AdminUserRepository;

@Service
@Transactional
public class AdminUserService implements IAdminUserService {
	
	@Autowired
	private AdminUserRepository adminUserRepo;

	@Override
	public List<Customer> fetchAllUsers() {
		return adminUserRepo.findAll();
	}

	@Override
	public Customer saveUserDetails(Customer transientUser) {
		return adminUserRepo.save(transientUser);
	}

	@Override
	public String deleteUserDetails(int userId) {
		adminUserRepo.deleteById(userId);
		return "User details deleted";
	}

	@Override
	public Customer getUserDetails(int userId) {
		return adminUserRepo.findById(userId).orElseThrow(() -> new UserHandlingException("Invalid User Id"));
	}

	@Override
	public Customer updateUserDetails(Customer detachedUser) {
		Customer cust=getUserDetails(detachedUser.getId());
		cust.setEmail(detachedUser.getEmail());
		cust.setPassword(detachedUser.getPassword());
		cust.setFirstName(detachedUser.getFirstName());
		cust.setLastName(detachedUser.getLastName());
		cust.setMiddleName(detachedUser.getMiddleName());
		cust.setMobile(detachedUser.getMobile());
		cust.setAddress(detachedUser.getAddress());
		return adminUserRepo.save(cust);
	}
	
	public Customer getUserByEmail(String email) {
		return adminUserRepo.getByEmail(email);
	}

	public Customer findById(int customerId) {
		return adminUserRepo.getById(customerId);
	}

}
