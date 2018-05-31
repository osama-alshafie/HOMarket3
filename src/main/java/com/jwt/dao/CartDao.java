package com.jwt.dao;

import java.util.List;

import com.jwt.model.Cart;
import com.jwt.model.CartItem;

public interface CartDao {

	public void AddCartItem(CartItem cartItem);

	public void EditCart(int counter, int id);

	public void deleteCartItems(List<CartItem> cartItemses);

	public List<Cart> getAllCarts();

	public Cart getCartByCustomer();

}
