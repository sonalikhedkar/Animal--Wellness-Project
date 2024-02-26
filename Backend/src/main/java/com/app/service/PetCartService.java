package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Breed;
import com.app.entities.CartToBreed;
import com.app.entities.CartToProduct;
import com.app.entities.Customer;
import com.app.entities.PetCart;
import com.app.entities.Product;
import com.app.excepe.CartException;
import com.app.repositories.AdminUserRepository;
import com.app.repositories.BreedRepository;
import com.app.repositories.CartToBreedRepository;
import com.app.repositories.PetCartRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class PetCartService implements IPetCartService {
	
	@Autowired
	PetCartRepository cartRepo ;
	
	@Autowired
	UserRepository userRepo ;
	
	@Autowired
	IUserService userService ;
	
	@Autowired
	IBreedService breedService ;
	
	@Autowired
	CartToBreedRepository cartBreedRepo ;
	
	@Autowired
	BreedRepository breedRepo ;
	
	@Autowired
	AdminUserRepository adminUserRepo;

	@Override
	public String addPetToByCart(int customerId, int petId) {
		Customer currentCust = userService.getCustomerById(customerId);
	  PetCart currentCart =currentCust.getCart1();
		
		Breed currentBreed =  breedService.getBreedDetails(petId);
		
		CartToBreed cb= new CartToBreed(currentCart.getId(),currentBreed.getId(),true);
	
		cartBreedRepo.save(cb) ;	
		currentCart.setQuantity(currentCart.getQuantity()+1);
		return " Added To Petcart";
		
	}

	@Override
	public List<Breed> getAllItemsByCart(int customerId) {
		Customer currentCustomer = userService.getCustomerById(customerId) ;
		int quantity = currentCustomer.getCart1().getQuantity() ;
		if(quantity == 0)
			 throw new CartException("Cart Is Empty ");
		
		List<CartToBreed> list = cartBreedRepo.findAllByCartId(currentCustomer.getCart1().getId()) ;
		List<Breed> cartpets = new ArrayList<Breed>();
		

		for(int i=0;i<quantity;i++) {
				if(list.get(i).isInCart()) {
						Breed p  = breedService.getBreedById(list.get(i).getBreedId());
						cartpets.add(p) ;
				}
		}
		return cartpets;
	}
//
//	@Override
//	public Integer getTotalPrice(int custmerId) {
//		List<Product>  product = getAllItemsByCart(custmerId) ;
//		int total = 0 ;
//		for(Product p : product) {
//			total += p.getPrice() ;
//		}
//		return total;
//	}
//	
//	public String deleteFromCart(Integer cartId,Integer productId ) {
//		Customer cust=adminUserRepo.getByCartId(cartId);
//		
//		int noOfProducts=cartProductRepo.findAllByCartIdAndProductId(cartId,productId ).size();
//		if(noOfProducts==0) {
//			return "no product available in cart";
//		}
//		else if(cust.getCart().getQuantity()==0) {
//			return "cart is empty";
//		}
//		else {
//			cartProductRepo.deleteByCartIdAndProductId(cartId, productId);
//			cust.getCart().setQuantity(cust.getCart().getQuantity()-noOfProducts);
//			return "product deleted";		
//		}
//	}
//
//	@Override
//	public void deleteAllfromCart(Integer id) {
//		cartProductRepo.deleteAllByCartId(id);	
//	}
//
//


	

	

}
