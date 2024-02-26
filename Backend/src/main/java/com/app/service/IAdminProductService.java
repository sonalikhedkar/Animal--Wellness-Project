package com.app.service;

import java.util.List;

import com.app.dto.AdminProduct;
import com.app.entities.Product;

public interface IAdminProductService {

    List<Product>fetchAllProducts();
	
    //add a method to delete product details
	String deleteProductDetails(int productId);
	//add method to fetch product details
	Product getProductDetails(int productId);
	//update product
	Product updateProductDetails(Product detachedProduct);

	Product saveProductDetails(AdminProduct transientProduct);
}