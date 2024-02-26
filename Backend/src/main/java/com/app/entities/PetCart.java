package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tblPetCart")
public class PetCart extends BaseEntity {
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
//		cart ---> breed 
		 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		@OneToMany(fetch = FetchType.LAZY,
				cascade = CascadeType.ALL)
		private List<Breed> breeds = new ArrayList<Breed>() ;

		
//		one cart having many order 
		@OneToMany(mappedBy = "cart"
				,fetch = FetchType.EAGER,
				cascade = CascadeType.ALL,
				orphanRemoval = true)
		private Set<PetOrder> orders = new HashSet<PetOrder>();


		public PetCart() {
			
		}
       
		public PetCart(int quantity, Status status, LocalDate date, Customer customer, List<Breed> breeds,HashSet<PetOrder> orders,Customer cust) {
			super();
			this.quantity = quantity;
			this.status = status;
			this.date = date;
			this.customer = customer;
			this.breeds = breeds;
			this.orders = orders;
			this.customer=cust;
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


		public List<Breed> getBreeds() {
			return breeds;
		}


		public void setBreeds(List<Breed> breeds) {
			this.breeds = breeds;
		}


		public Set<PetOrder> getPetOrders() {
			return orders;
		}


		public void setPetOrders(Set<PetOrder> orders) {
			this.orders = orders;
		}

		
}
