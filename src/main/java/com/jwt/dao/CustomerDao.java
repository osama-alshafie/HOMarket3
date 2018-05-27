package com.jwt.dao;

import com.jwt.model.Customer;

import java.util.List;

public interface CustomerDao {

    public void AddCustomer(Customer cust);

    public void updateCustomer(Customer cust);

    public void deleteCustomer(int id);

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int custId);

	public Customer getCustomerByName(String custName);



}
