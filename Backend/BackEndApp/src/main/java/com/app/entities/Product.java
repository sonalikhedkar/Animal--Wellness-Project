package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tblProduct")
public class Product extends BaseEntity {

//	category id many to one 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cat_id")
	@JsonIgnore
	private Category category ;
	
//	vendor id 
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user ;
	
	@Column(nullable = false)
	private String name ;
	
	@Column(nullable = false)
	private String description ;
	
//	image 
	@Column
	private String imgUrl ;
	
	@Column(nullable = false)
	private int price ; 
	
	@Column
	private float discount;
	
	@Column(nullable = false)
	private boolean isActive = true;



	public Product() {
	
	}

	public Product(Category category, User user, String name, String description, String imgUrl, int price,
			float discount, boolean isActive) {
		super();
		this.category = category;
		this.user = user;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.price = price;
		this.discount = discount;
		this.isActive = isActive;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
}
