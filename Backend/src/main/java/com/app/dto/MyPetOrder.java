package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Breed;
import com.app.entities.PMode;

import com.app.entities.Status;

public class MyPetOrder {
	private List<Breed> petList ;
	private int quantity;
	private Status status ;
	private PMode pStatus ;
	private LocalDate date;
	private String address;
	private double total;
	public MyPetOrder() {
		super();
	}
	public MyPetOrder(List<Breed> list, int quantity, Status status, PMode pStatus, LocalDate date, String address,
			double total) {
		super();
		this.petList = list;
		this.quantity = quantity;
		this.status = status;
		this.pStatus = pStatus;
		this.date = date;
		this.address = address;
		this.total = total;
	}
	public List<Breed> getList() {
		return petList;
	}
	public void setList(List<Breed> list) {
		this.petList = list;
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
	public PMode getpStatus() {
		return pStatus;
	}
	public void setpStatus(PMode pStatus) {
		this.pStatus = pStatus;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
