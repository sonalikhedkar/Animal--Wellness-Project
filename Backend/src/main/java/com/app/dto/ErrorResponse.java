package com.app.dto;

import java.time.LocalDate;



public class ErrorResponse {
		
	private String message ;
	private LocalDate localDate ;
	
	public ErrorResponse() {
		super();
	}
	public ErrorResponse(String message, LocalDate localDate) {
		super();
		this.message = message;
		this.localDate = localDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	
}
