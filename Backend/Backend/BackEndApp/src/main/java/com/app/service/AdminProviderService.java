 package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.Login;
import com.app.entities.Provider;
import com.app.excepe.UserHandlingException;
import com.app.repositories.AdminProviderRepository;


@Service
@Transactional
public class AdminProviderService implements IAdminProviderService {
	
	@Autowired
	private AdminProviderRepository adminProviderRepo;

	@Override
	public List<Provider> fetchAllUsers() {
		return adminProviderRepo.findAll();
	}

	@Override
	public Provider saveProviderDetails(Provider transientUser) {
		return adminProviderRepo.save(transientUser);
	}

	@Override
	public String deleteProviderDetails(int userId){
		adminProviderRepo.deleteById(userId);
		return "Provider details deleted";
	}

	@Override
	public Provider getProviderDetails(int userId) {
		return adminProviderRepo.findById(userId).orElseThrow(() -> new UserHandlingException("Invalid User Id"));
	}

	@Override
	public Provider updateProviderDetails(Provider detachedUser) {
	Provider pro=getProviderDetails(detachedUser.getId());
	pro.setEmail(detachedUser.getEmail());
	pro.setPassword(detachedUser.getPassword());
	pro.setFirstName(detachedUser.getFirstName());
	pro.setLastName(detachedUser.getLastName());
	pro.setMiddleName(detachedUser.getMiddleName());
	pro.setMobile(detachedUser.getMobile());
	pro.setAddress(detachedUser.getAddress());
		return adminProviderRepo.save(pro);
	}

//	@Override
//	public Provider getProviderByEmail(String email) {
//		
//		return adminProviderRepo.getByEmail(email);
//	}
	
	public Provider findById(int providerId) {
		return adminProviderRepo.getById(providerId);
	}

	
	@Override
	public Provider loginAsAProvider(Login login) {
		Provider pro = adminProviderRepo.findByEmail(login.getEmail());
		if (pro.getPassword().equals(login.getPassword())) {
			System.out.println("password comparison done");
			return pro;
		}
		throw new UserHandlingException("Invalid Provider Or Password");
	}

	@Override
	public Provider getProviderByEmail(String email) {
		return adminProviderRepo.getByEmail(email);
		
	}

}
