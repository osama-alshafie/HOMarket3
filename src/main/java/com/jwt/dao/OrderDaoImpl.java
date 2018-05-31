package com.jwt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.Category;
import com.jwt.model.Customer;
import com.jwt.model.Orders;
import com.jwt.service.CustomerService;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerService customerService;

	@Override
	public void CreateOrder(Orders order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public void editOrder(Orders order) {

		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

	@Override
	public void deleteOrder(Orders order) {

		sessionFactory.getCurrentSession().delete(order);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrderByCustomer() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		Customer cust = customerService.getCustomerByName(user.getUsername());

		Query query = sessionFactory.getCurrentSession()
				.createQuery("select o from Orders o inner join o.cust c where c=:cust ");
		query.setParameter("cust", cust);

		return (List<Orders>) query.list();
	}

}
