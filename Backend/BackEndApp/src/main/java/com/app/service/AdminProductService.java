package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.excepe.ProductException;
import com.app.repositories.AdminProductRepository;
import com.app.repositories.CategoryRepository;
import com.app.repositories.ProductRepository;
import com.app.dto.AdminProduct;
import com.app.entities.Product;

@Service
@Transactional
public class AdminProductService implements IAdminProductService {

	@Autowired
	private AdminProductRepository adminProductRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@Override
	public List<Product> fetchAllProducts() {
		return adminProductRepo.findAll();
	}
	

	@Override
	public Product saveProductDetails(AdminProduct transientProduct) {  
	    Product product = new Product(categoryRepo.findByName(transientProduct.getCategory()),null,transientProduct.getName(),transientProduct.getDescription(),transientProduct.getImgUrl(),transientProduct.getPrice(),transientProduct.getDiscount(),transientProduct.isActive());
		return adminProductRepo.save(product);
	}

	@Override
	public String deleteProductDetails(int productId) {
		Product product = productRepo.getById(productId);
		if(product != null)
		{
			adminProductRepo.deleteById(product.getId());
			return "Product Details Deleted";
		}
		else
			throw new ProductException("Product Not Found ");
			
	}

	@Override
	public Product getProductDetails(int productId) {
		return adminProductRepo.findById(productId).orElseThrow(() -> new ProductException("Invalid Product Id"));
	}
			
	@Override
	public Product updateProductDetails(Product detachedProduct) {
		return adminProductRepo.save(detachedProduct);
	}

}
