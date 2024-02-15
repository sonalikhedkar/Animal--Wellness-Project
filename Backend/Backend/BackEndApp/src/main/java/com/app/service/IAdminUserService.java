package com.app.service;

import java.util.List;

import com.app.entities.Customer;


public interface IAdminUserService {

List<Customer>fetchAllUsers();
	
    Customer saveUserDetails(Customer transientUser);
	//add a method to delete user details
	String deleteUserDetails(int userId);
	//add method to fetch user details
	Customer getUserDetails(int userId);
	//update user
	Customer updateUserDetails(Customer detachedUser);
	
	public Customer getUserByEmail(String email); 
}
