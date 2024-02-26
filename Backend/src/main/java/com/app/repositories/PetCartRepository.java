package com.app.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


import com.app.entities.CartToBreed;
import com.app.entities.PetCart;

public interface PetCartRepository extends CrudRepository<PetCart, Integer> {

	

}
