package com.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.CartToProduct;

public interface CartToProductRepository extends CrudRepository<CartToProduct, Integer> {
	List<CartToProduct> findAllByCartId(int cartId) ;
	
	List<CartToProduct> findAllByCartIdAndProductId(Integer cartId,Integer productId);
	
	void deleteAllByCartId(Integer cartId);
	
	void deleteByCartIdAndProductId(Integer cartId,Integer productId);
	
	
}
