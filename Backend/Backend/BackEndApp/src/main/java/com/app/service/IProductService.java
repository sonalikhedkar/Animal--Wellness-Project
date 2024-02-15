package com.app.service;

import java.util.List;

import com.app.entities.Product;

public interface IProductService {
//		public abstract 
			List<Product> fetchAllProducts() ;
	
//		get a particular product 
			Product getProductById(int productId) ;
			

			List<Product> findByCategoryTable();

			List<Product> findByCategorySofa();

			List<Product> findByCategoryChair();
	
}
