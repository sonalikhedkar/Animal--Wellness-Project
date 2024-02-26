package com.app.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.app.entities.CartToBreed;
import com.app.entities.CartToProduct;

public interface CartToBreedRepository  extends CrudRepository<CartToBreed, Integer> {
		List<CartToBreed> findAllByCartId(int cartId) ;
		
		List<CartToBreed> findAllByCartIdAndBreedId(Integer cartId,Integer breedId);
		
		void deleteAllByCartId(Integer cartId);
		
		void deleteByCartIdAndBreedId(Integer cartId,Integer breedId);
		
		
		
}
