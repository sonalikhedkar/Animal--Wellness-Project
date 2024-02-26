package com.app.dto;

import javax.persistence.Column;


public class AdminProduct {

    private String category ;

	@Column(nullable = false)
	private String name ;
	
	@Column(nullable = false)
	private String description ;
	
	@Column(nullable = false)
	private String imgUrl ;
	
	@Column(nullable = false)
	private int price ; 
	
	@Column
	private float discount;
	
	@Column(nullable = false)
	private boolean isActive = true;
	
	public AdminProduct() {}
	
	public AdminProduct(String category, String name, String description, String imgUrl, int price, float discount,
			boolean isActive) {
		super();
		this.category = category;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.price = price;
		this.discount = discount;
		this.isActive = isActive;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}

	public int getPrice() {
		return price;
	}


	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
