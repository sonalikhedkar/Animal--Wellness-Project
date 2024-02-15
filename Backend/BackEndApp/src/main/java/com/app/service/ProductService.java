package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Product;
import com.app.excepe.ProductException;
import com.app.repositories.ProductRepository;
@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepo ;
	
	@Override
	public List<Product> fetchAllProducts() {
			System.out.println("in product serivec method ");
			return productRepo.findAll() ;
	}

	@Override
	@Transactional 
	public Product getProductById(int productId) {
		return productRepo.findById(productId).orElseThrow(() -> new ProductException("product not found "));
	}
	
	@Override
	public List<Product> findByCategoryTable() {
		System.out.println("in product category Table");
		return productRepo.findByCategoryTable();
	}

	@Override
	public List<Product> findByCategorySofa() {
		System.out.println("in product category Sofa");
		return productRepo.findByCategorySofa();
	}

	@Override
	public List<Product> findByCategoryChair() {
		System.out.println("in product category Chair");
		return productRepo.findByCategoryChair();
	}


}
