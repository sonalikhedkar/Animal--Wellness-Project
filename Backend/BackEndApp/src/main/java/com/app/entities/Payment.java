package com.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tblPayment")
public class Payment extends BaseEntity {

	
//	one order having one payment details 
	@OneToOne(fetch = FetchType.LAZY ,
			cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order ;
	
	@OneToOne(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY )
	@JoinColumn(name = "pm_id")
	private PaymentMode mode ;
	
	@Column(nullable = false)
	private int Amount;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
		private Status status ;
		
	@Column
	private LocalDate date;
	
	public Payment() {}

	public Payment(Order order, PaymentMode mode, int amount, Status status, LocalDate date) {
		super();
		this.order = order;
		this.mode = mode;
		Amount = amount;
		this.status = status;
		this.date = date;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
