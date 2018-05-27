package com.jwt.dao;

import com.jwt.model.Orders;
import com.jwt.model.Role;

public interface OrderDao {

	public void CreateOrder(Orders order);

	public void editOrder(Orders order);

	public void deleteOrder(Orders order);

}
