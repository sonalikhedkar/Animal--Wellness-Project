package com.app.service;

import java.util.List;

import com.app.dto.Login;
import com.app.entities.Provider;


public interface IAdminProviderService {

List<Provider>fetchAllUsers();
	
Provider saveProviderDetails(Provider transientUser);
	//add a method to delete user details
	String deleteProviderDetails(int userId);
	//add method to fetch user details
	Provider getProviderDetails(int userId);
	//update user
	Provider updateProviderDetails(Provider detachedUser);
	
	public Provider getProviderByEmail(String email); 
	
	Provider loginAsAProvider(Login login) ;
}
