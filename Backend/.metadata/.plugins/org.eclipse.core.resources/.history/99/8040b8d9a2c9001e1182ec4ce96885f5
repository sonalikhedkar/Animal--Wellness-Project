package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblUser")
public class User extends BaseEntity {
	
	@Column(length = 20 , nullable = false)
	private String firstName ;
	
	@Column(length = 20 , nullable = true)
	private String middleName ;
	
	@Column(length = 20 , nullable = false)
	private String lastName ;
	
	@Column(nullable = false , unique = true)
	private String email ;
	
	@Column(length = 13)
	private String mobileNum;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Role role ;
	
	@Column(nullable =  false)
	private boolean isActive  ;

	@Column(nullable =  false)
	private String address ;
	
	@Column(length = 20 , nullable = false)
	private String password ;
	
//	one to many relationship with product 
	@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL ,
			fetch = FetchType.EAGER ,
			orphanRemoval = true)
	private List<Product> products = new ArrayList<Product>() ;

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

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
