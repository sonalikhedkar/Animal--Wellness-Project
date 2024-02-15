package com.app.entities;

import javax.persistence.Entity;



@Entity(name = "tblCartProduct")
public class CartToProduct extends BaseEntity{
	private Integer cartId ;
	private Integer productId ;
	private boolean isInCart = true;
	
	
	public CartToProduct() {}
	public CartToProduct(Integer cartId, Integer productId, boolean isInCart) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.isInCart = isInCart;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public boolean isInCart() {
		return isInCart;
	}
	public void setInCart(boolean isInCart) {
		this.isInCart = isInCart;
	}
	
}
