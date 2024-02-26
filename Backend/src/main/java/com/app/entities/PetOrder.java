package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblPetOrder")
public class PetOrder extends BaseEntity{
//	cart --- customer
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private Customer customer ;
	
	
//	cart --- order 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id")
	private PetCart cart ;
	
//	one to one with payment 
	
	@Column(nullable = false)
	private int quantity ;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Status status ;
	
	@Column(nullable = false)
	private int price;
	
	@Column
	private LocalDate date;
	
	public PetOrder() {}

	public PetOrder(Customer customer, PetCart cart, int quantity, Status status, int price, LocalDate date) {
		super();
		this.customer = customer;
		this.cart = cart;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PetCart getCart() {
		return cart;
	}

	public void setPetCart(PetCart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
