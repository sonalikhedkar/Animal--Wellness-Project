package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "tblBreed")
public class Breed extends BaseEntity {
	
//	vendor id 
	//
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "provider_id")
	@JsonIgnore
	private Provider provider ;
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "cust_id")
	@JsonIgnore
	private Customer customer ;
	
	@Column(nullable = false)
	private String name ;
	
	@Column(nullable = false)
	private String type ;
	
	@Column(nullable = false)
	private String breed ;
	
	@Column(nullable = false)
	private String gender ;
	
	@Column(nullable = false)
	private int age ;
	
	@Column(nullable = false)
	private int weight ;
	
	@Column(nullable = false)
	private String description ;
	
	@Column(nullable =true)
	private double price;
	
	@Column
	private String imgUrl ;


	public Breed() {
	
	}
    

	public Breed(Provider provider, Customer customer, String name, String type, String breed, String gender, int age,
			int weight, String description, double price, String imgUrl) {
		super();
		this.provider = provider;
		this.customer = customer;
		this.name = name;
		this.type = type;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
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
	
	

}
