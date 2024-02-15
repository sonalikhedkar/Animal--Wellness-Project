package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("select p from Product p join Category c on p.category=c.id where c.name='Table'")
	List<Product>findByCategoryTable();
	
	@Query("select p from Product p join Category c on p.category=c.id where c.name='Sofa'")
	List<Product>findByCategorySofa();
	
	@Query("select p from Product p join Category c on p.category=c.id where c.name='Chair'")
	List<Product>findByCategoryChair();

}