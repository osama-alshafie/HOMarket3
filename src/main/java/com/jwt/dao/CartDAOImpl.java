package com.jwt.dao;

import com.jwt.model.Cart;
import com.jwt.model.CartItem;
import com.jwt.model.Customer;
import com.jwt.model.Product;
import com.jwt.service.CustomerService;
import com.jwt.service.ProductService;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CartDAOImpl implements CartDao {

	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void AddCartItem(CartItem cartItem) {

		sessionFactory.getCurrentSession().save(cartItem);

	}

	@Override
	public void EditCart(int counter, int id) {

		CartItem cartItem = new CartItem();

		cartItem.setProduct(productService.getProductById(id));
		cartItem.setQuantity(counter);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		Customer customUser = customerService.getCustomerByName(user.getUsername());
		Cart cart = customUser.getCart();
		cartItem.setDeleted(false);
		cart.getCartItemList().add(cartItem);
		cartItem.setCart(cart);

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
			cartItem2.setDeleted(true);
			sessionFactory.getCurrentSession().update(cartItem2);
			// sessionFactory.getCurrentSession().delete(cartItem2);
			sessionFactory.getCurrentSession().flush();
		}
	}

	@Override
	public Cart getCartByCustomer() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		Customer customUser = customerService.getCustomerByName(user.getUsername());
		Cart carts = customUser.getCart();
		return carts;
	}

}