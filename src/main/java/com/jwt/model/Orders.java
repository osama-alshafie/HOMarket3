package com.jwt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Orders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String address;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// =============================================================================\\
	/* Mapping */
	// =============================================================================\\

	@ManyToOne(/* cascade = CascadeType.ALL, */ fetch = FetchType.EAGER)
	private Customer cust;

	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

}
