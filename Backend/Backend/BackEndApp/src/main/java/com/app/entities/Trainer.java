package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "tblTrainer")
public class Trainer extends BaseEntity{
   
    @Column(length = 20 , nullable = false)
	private String firstName ;
    
    @Column(length = 20 , nullable = false)
	private String lastName ;
	
	@Column(length = 20 , nullable = true)
	 private String gender;
	
	@Column(nullable = false , unique = true)
	private String email ;
	
	@Column(length = 13)
	private String mobileNum;
	
	
	@Column(nullable =  false)
	private boolean isActive  ;
	
	@Column(nullable = false)
	private int Experience;
	
	@Column(nullable = true)
    private double fees;

	@Column(nullable =  false)
	private String address ;

	public Trainer() {
		super();
	}

	public Trainer(String firstName, String lastName, String gender, String email, String mobileNum, boolean isActive,
			int experience, double fees, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.mobileNum = mobileNum;
		this.isActive = isActive;
		Experience = experience;
		this.fees = fees;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getExperience() {
		return Experience;
	}

	public void setExperience(int experience) {
		Experience = experience;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
