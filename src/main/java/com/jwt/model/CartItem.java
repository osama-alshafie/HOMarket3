package com.jwt.model;

import javax.persistence.*;

@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private int id;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// =============================================================================\\
	/* Mapping */
	// =============================================================================\\
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cart cart;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
