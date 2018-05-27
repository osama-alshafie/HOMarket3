package com.jwt.service;

import com.jwt.model.Customer;
import com.jwt.model.Employee;

import java.util.List;

public interface CustomerService {

	public void AddCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public void deleteCustomer(int id);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(int custId);

	public Customer getCustomerByName(String custName);
}
