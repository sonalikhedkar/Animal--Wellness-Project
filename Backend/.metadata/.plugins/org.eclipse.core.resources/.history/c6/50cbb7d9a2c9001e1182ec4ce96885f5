package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tblCart")
public class Cart extends BaseEntity {
		@Column(nullable = false)
		private int quantity ;
		
		@Enumerated(EnumType.STRING)
		@Column
		private Status status ;
		
		@Column
		private LocalDate date;
		
//		one to one 
//		cart --- customer
		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "cust_id")
		private Customer customer ;
		
//		one to many 
//		cart ---> product 
		@OneToMany(fetch = FetchType.EAGER,
				cascade = CascadeType.ALL)
		private List<Product> products = new ArrayList<Product>() ;

		
//		one cart having many order 
		@OneToMany(mappedBy = "cart"
				,fetch = FetchType.LAZY,
				cascade = CascadeType.ALL,
				orphanRemoval = true)
		private List<Order> orders = new ArrayList<Order>();


		public Cart() {}
		
		public Cart(int quantity, Status status, LocalDate date, Customer customer, List<Product> products,List<Order> orders) {
			super();
			this.quantity = quantity;
			this.status = status;
			this.date = date;
			this.customer = customer;
			this.products = products;
			this.orders = orders;
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


		public LocalDate getDate() {
			return date;
		}


		public void setDate(LocalDate date) {
			this.date = date;
		}


		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public List<Product> getProducts() {
			return products;
		}


		public void setProducts(List<Product> products) {
			this.products = products;
		}


		public List<Order> getOrders() {
			return orders;
		}


		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		
}
