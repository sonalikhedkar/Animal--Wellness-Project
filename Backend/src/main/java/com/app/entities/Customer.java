package com.app.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tblCust")
public class Customer extends BaseEntity {
	@Column(length = 20 , nullable = false)
	private String firstName ;
	
	@Column(length = 20)
	private String middleName ;
	
	@Column(length = 20 , nullable = false)
	private String lastName ;
	
	@Column(nullable = false , unique = true)
	private String email ;
	
	@Column(length = 13)
	private String mobile;
	
	@Column(nullable = false)
	private boolean isActive = true ;

	@Column(nullable = false)
	private String address ;
	
	@Column(length = 20 , nullable = false)
	private String password ;
	
	//one to many relationship with pets 
//	@OneToMany(mappedBy = "customer",
//			cascade = CascadeType.ALL ,
//			fetch = FetchType.LAZY ,
//			orphanRemoval = true)
//	private List<Breed> pets = new ArrayList<Breed>() ;
	
//	one to one 
//	cust ---> cart 
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id")
	@JsonIgnore
	private Cart cart ;
	
	//one to one 
//	cust ---> cart 
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "petcart_id")
	@JsonIgnore
	private PetCart cart1 ;
	
//	one to many 
//	one cust having many order
	@JsonIgnore
	@OneToMany(mappedBy = "customer",
				fetch = FetchType.LAZY
				,cascade = CascadeType.ALL,
				orphanRemoval = true)
	private List<Order> orders = new ArrayList<Order>();
	
//	one to many 
//	one cust having many order
	@JsonIgnore
	@OneToMany(mappedBy = "customer",
				fetch = FetchType.EAGER
				,cascade = CascadeType.ALL,
				orphanRemoval = true)
	private Set<PetOrder> Petorders = new HashSet<PetOrder>();
	

	public Customer() {
		super();
		
	}
	
	public Customer(String firstName, String middleName, String lastName, String email, String mobile, boolean isActive,
		String address, String password, Cart cart, List<Order> orders, PetCart petcart, HashSet<PetOrder> petorders) {
	super();
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.email = email;
	this.mobile = mobile;
	this.isActive = isActive;
	this.address = address;
	this.password = password;
	this.cart = cart;
	this.orders = orders;
	this.cart1 = petcart;
	this.Petorders=petorders;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	

	public Set<PetOrder> getPetorders() {
		return Petorders;
	}

	public void setPetorders(Set<PetOrder> petorders) {
		Petorders = petorders;
	}

	public PetCart getCart1() {
		return cart1;
	}

	public void setCart1(PetCart petcart) {
		this.cart1 = petcart;
	}

//	public List<Breed> getPets() {
//		return pets;
//	}
//
//	public void setPets(List<Breed> pets) {
//		this.pets = pets;
//	}
//	

	

	

	
}
