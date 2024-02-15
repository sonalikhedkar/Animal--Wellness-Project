package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.excepe.UserHandlingException;
import com.app.repositories.CartRepository;
import com.app.repositories.UserRepository;
import com.app.dto.Login;
import com.app.entities.Cart;
import com.app.entities.Customer;
import com.app.entities.Order;
import com.app.entities.Product;
import com.app.entities.Status;

@Service
@Transactional
public class UserSerivce implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	CartRepository cartRepo;

	@Override
	public String saveUser(Customer cust) {
		System.out.println("in a service save user ");
		Customer newCust = userRepo.save(cust);
		createUserCart(newCust);
		return "Custmer Added Successfully ";
	}

	@Override
	public Cart createUserCart(Customer cust) {
		Cart currentCustCart = new Cart(0, Status.PENDING, LocalDate.now(), cust, new ArrayList<Product>(),
				new ArrayList<Order>());
		Cart newCart = cartRepo.save(currentCustCart);
		Customer getCust = newCart.getCustomer();
		getCust.setCart(newCart);
		return cartRepo.save(currentCustCart);
	}

	@Override
	public Customer loginAsACustomer(Login login) {
		Customer cust = userRepo.findByEmail(login.getEmail());
		if (cust.getPassword().equals(login.getPassword())) {
			System.out.println("password comparison done");
			return cust;
		}
		throw new UserHandlingException("Invalid Customer Or Password");
	}

	@Override
	public Customer getCustomerById(int custId) {
		return userRepo.findById(custId).orElseThrow(() -> new UserHandlingException("Invalid Customer ID"));
	}

}
