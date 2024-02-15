package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.PMode;
import com.app.entities.Product;
import com.app.entities.Status;


public class MyOrder {
	
	private List<Product> list ;
	private int quantity;
	private Status status ;
	private PMode pStatus ;
	private LocalDate date;
	private String address;
	private double total;
	
	public MyOrder() {
		super();
	}

	public MyOrder(List<Product> list, int quantity, Status status, PMode pStatus, LocalDate date, String address,double total) {
		super();
		this.list = list;
		this.quantity = quantity;
		this.status = status;
		this.pStatus = pStatus;
		this.date = date;
		this.address = address;
		this.total=total;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
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
	
	

}
