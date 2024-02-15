package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Cart;
import com.app.entities.CartToProduct;
import com.app.entities.Customer;
import com.app.entities.Product;
import com.app.excepe.CartException;
import com.app.repositories.AdminUserRepository;
import com.app.repositories.CartRepository;
import com.app.repositories.CartToProductRepository;
import com.app.repositories.ProductRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class CartService implements ICartService {
	
	
	
	@Autowired
	CartRepository cartRepo ;
	
	@Autowired
	UserRepository userRepo ;
	
	@Autowired
	IUserService userService ;
	
	@Autowired
	IProductService productService ;
	
	@Autowired
	CartToProductRepository cartProductRepo ;
	
	@Autowired
	ProductRepository productRepo ;
	
	@Autowired
	AdminUserRepository adminUserRepo;
	

	@Override
	public String addProductToCart(int customerId, int productId){
		Customer currentCust = userService.getCustomerById(customerId) ;
		Cart currentCart = currentCust.getCart() ;
		Product currentProduct = productService.getProductById(productId) ;
		CartToProduct cp = new CartToProduct(currentCart.getId(), currentProduct.getId(), true);
		cartProductRepo.save(cp) ;	
		currentCart.setQuantity(currentCart.getQuantity()+1);
		return " Added To Cart ";
	}

	@Override
	public List<Product> getAllItemsByCart(int customerId) {
		Customer currentCustomer = userService.getCustomerById(customerId) ;
		int quantity = currentCustomer.getCart().getQuantity() ;
		if(quantity == 0)
			 throw new CartException("Cart Is Empty ");
		
		List<CartToProduct> list = cartProductRepo.findAllByCartId(currentCustomer.getCart().getId()) ;
		List<Product> cartProducts = new ArrayList<Product>();

		for(int i=0;i<quantity;i++) {
				if(list.get(i).isInCart()) {
						Product p  = productService.getProductById(list.get(i).getProductId());
						cartProducts.add(p) ;
				}
		}
		return cartProducts;
	}

	@Override
	public Integer getTotalPrice(int custmerId) {
		List<Product>  product = getAllItemsByCart(custmerId) ;
		int total = 0 ;
		for(Product p : product) {
			total += p.getPrice() ;
		}
		return total;
	}
	
	public String deleteFromCart(Integer cartId,Integer productId ) {
		Customer cust=adminUserRepo.getByCartId(cartId);
		
		int noOfProducts=cartProductRepo.findAllByCartIdAndProductId(cartId,productId ).size();
		if(noOfProducts==0) {
			return "no product available in cart";
		}
		else if(cust.getCart().getQuantity()==0) {
			return "cart is empty";
		}
		else {
			cartProductRepo.deleteByCartIdAndProductId(cartId, productId);
			cust.getCart().setQuantity(cust.getCart().getQuantity()-noOfProducts);
			return "product deleted";		
		}
	}

	@Override
	public void deleteAllfromCart(Integer id) {
		cartProductRepo.deleteAllByCartId(id);	
	}

}
