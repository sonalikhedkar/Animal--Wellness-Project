package com.app.entities;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "tblProvider")
public class Provider extends BaseEntity {
	
	@OneToMany(mappedBy = "provider",
			cascade = CascadeType.ALL ,
			fetch = FetchType.EAGER ,
			orphanRemoval = true)
	private List<Hostel> hostels = new ArrayList<Hostel>() ;
	
	
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
	

	public Provider() {
		
	}

	public Provider(String firstName, String middleName, String lastName, String email, String mobile, boolean isActive,
			String address, String password) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.isActive = isActive;
		this.address = address;
		this.password = password;
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
	
	
	
	
	
	
	
	
}
