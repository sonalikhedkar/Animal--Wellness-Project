package com.app.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartProcess;
import com.app.dto.PetCartProcess;
import com.app.entities.Breed;
import com.app.entities.Cart;
import com.app.entities.CartToProduct;
import com.app.entities.Customer;
import com.app.entities.Product;
import com.app.service.AdminUserService;
import com.app.service.CartService;
import com.app.service.ICartService;
import com.app.service.IPetCartService;

@RestController
@RequestMapping("/petcart")
@CrossOrigin(origins = "*")
// /cart/
public class PetCartController {
	
	@Autowired
	IPetCartService cartService  ;
	
	@Autowired 
	AdminUserService adminUserService;	
	
	@PostMapping("/add-pet")
	public String addToCart(@RequestBody PetCartProcess PetcartProcess) {
		return cartService.addPetToByCart(PetcartProcess.getCustomerId(), PetcartProcess.getBreedId()); 
	}

	
	@GetMapping("/pets/{customerId}")
	public List<Breed> getAllItemsInACart(@PathVariable int customerId){
		return cartService.getAllItemsByCart(customerId) ;
	}
	
	@GetMapping("/user-cart/{customerId}")
	public Integer getPetCartOfUser(@PathVariable int customerId) {
		Customer cust=adminUserService.getUserDetails(customerId);
		return cust.getCart1().getId();
	}
//	
//	@DeleteMapping("/delete-item/{cartId}/{productId}")
//	public String deleteProductFromCart(@PathVariable int cartId, @PathVariable int productId){
//		return cartService.deleteFromCart(cartId,productId);
//	}
	
}
