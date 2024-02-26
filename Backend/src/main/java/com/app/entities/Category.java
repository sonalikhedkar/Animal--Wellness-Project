package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblCategory")
public class Category extends BaseEntity{
	
	@Column(length = 20 ,unique = true , nullable = false)
	private String name ;
	
	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private boolean isActive ;
	
//	one to many 
	@OneToMany(mappedBy = "category",
			fetch = FetchType.EAGER ,
			  cascade = CascadeType.ALL ,
			 orphanRemoval = true)
	private List<Product> products = new ArrayList<Product>() ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
}
