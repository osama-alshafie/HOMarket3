package com.jwt.dao;

import com.jwt.model.Cart;
import com.jwt.model.CartItem;
import com.jwt.model.Product;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CartDAOImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void AddCartItem(CartItem cartItem) {

		sessionFactory.getCurrentSession().save(cartItem);

	}

	@Override
	public void EditCart(Cart cart) {

		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Override
	public List<Cart> getAllCarts() {

		Query q = sessionFactory.getCurrentSession().createQuery("from Cart");
		List<Cart> carts = (List<Cart>) q.list();

		return carts;
	}

	@Override
	public void deleteCartItems(List<CartItem> cartItemses) {
		for (CartItem cartItem2 : cartItemses) {

			sessionFactory.getCurrentSession().delete(cartItem2);
			sessionFactory.getCurrentSession().flush();
		}

	}

}