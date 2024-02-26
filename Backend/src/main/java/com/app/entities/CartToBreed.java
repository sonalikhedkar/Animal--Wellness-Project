package com.app.entities;

import javax.persistence.Entity;

@Entity(name = "tblCartPet")

public class CartToBreed  extends BaseEntity{
	private int cartId ;
	private int breedId ;
	private boolean isInCart = true;
	public CartToBreed() {
		super();
	}
	public CartToBreed(int petcartId, int breedId, boolean isInCart) {
		super();
		this.cartId = petcartId;
		this.breedId = breedId;
		this.isInCart = isInCart;
	}
	public Integer getcartId() {
		return cartId;
	}
	public void setcartId(int petcartId) {
		this.cartId = petcartId;
	}
	public int getBreedId() {
		return breedId;
	}
	public void setBreedId(int breedId) {
		this.breedId = breedId;
	}
	public boolean isInCart() {
		return isInCart;
	}
	public void setInCart(boolean isInCart) {
		this.isInCart = isInCart;
	}
	

}
