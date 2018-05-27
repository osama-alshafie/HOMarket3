package com.jwt.service;

import java.util.List;

import com.jwt.model.Cart;
import com.jwt.model.CartItem;

public interface CartService {

	public void AddCartItem(CartItem cartItem);

	public void EditCart(Cart cart);

	public List<Cart> getAllCarts();

	public void deleteCartItems(List<CartItem> cartItemses);

}
