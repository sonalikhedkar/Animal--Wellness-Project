package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblFeedBack")
public class FeedBack extends BaseEntity{

	private String description;
	private int rating;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="custId")
	private Customer customer;
	public FeedBack() {
		super();
	}
	public FeedBack(String description, int rating, Customer customer) {
		super();
		this.description = description;
		this.rating = rating;
		this.customer = customer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
