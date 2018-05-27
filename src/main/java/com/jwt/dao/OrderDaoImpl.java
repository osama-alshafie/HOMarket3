package com.jwt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.Orders;
import com.jwt.model.Role;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void CreateOrder(Orders order) {
		sessionFactory.getCurrentSession().save(order);
		
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
		System.out.println("Order hereeeeeeeeeeeeeeeeeee");
	}

	@Override
	public void editOrder(Orders order) {

		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

	@Override
	public void deleteOrder(Orders order) {

		sessionFactory.getCurrentSession().delete(order);
	}

}
