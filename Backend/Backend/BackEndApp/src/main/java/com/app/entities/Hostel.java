package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tblHostel")
public class Hostel extends BaseEntity {
	
//	vendor id 
	@ManyToOne(
		    cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	private Provider provider ;
	
	@Column(nullable = false)
	private String name ;
	
	@Column(nullable = false)
	private String description ;
	
//	image 
	@Column
	private String imgUrl ;
	
	@Column(nullable = false)
	private int price ; 
	
     
	
	@Column(nullable = false)
	private boolean isActive = true;
	
	@Column(nullable = false)
	private String address ;

	
	@Column
	private float pincode;
	
	@Column(nullable = false)
	private String contact ;

	public Hostel() {
	
	}

	public Hostel(Provider provider, String name, String description, String imgUrl, int price, boolean isActive,
			String address, float pincode, String contact) {
		super();
		this.provider = provider;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.price = price;
		this.isActive = isActive;
		this.address = address;
		this.pincode = pincode;
		this.contact = contact;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getPincode() {
		return pincode;
	}

	public void setPincode(float pincode) {
		this.pincode = pincode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
