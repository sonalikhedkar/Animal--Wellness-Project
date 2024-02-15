package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tblShipment")
public class Shipment extends BaseEntity {

//	one shipment having one order id 
	@OneToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "order_id")
//	@JsonIgnore
	private Order order ;
	
	@Column(length = 20 ,nullable = false)
	private String shipingAddress ;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PMode mode ;
	
	@Column(nullable = false)
	private int price;
	

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status ;


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getShipingAddress() {
		return shipingAddress;
	}

	public void setShipingAddress(String shipingAddress) {
		this.shipingAddress = shipingAddress;
	}

	public PMode getMode() {
		return mode;
	}

	public void setMode(PMode mode) {
		this.mode = mode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
