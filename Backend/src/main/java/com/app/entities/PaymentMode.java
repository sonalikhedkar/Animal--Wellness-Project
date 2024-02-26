package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;



@Entity
@Table(name = "tblPayMode")
public class PaymentMode extends BaseEntity {
	
	@Column
	@Enumerated(EnumType.STRING)
	private PMode mode ;
	
	public PaymentMode() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentMode(PMode mode) {
		super();
		this.mode = mode;
	}


	public PMode getMode() {
		return mode;
	}


	public void setMode(PMode mode) {
		this.mode = mode;
	}


	@Override
	public String toString() {
		return "PaymentMode [mode=" + mode + "]";
	}
	
	
}
