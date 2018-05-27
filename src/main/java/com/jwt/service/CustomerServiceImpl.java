package com.jwt.service;

import com.jwt.dao.CustomerDao;
import com.jwt.dao.EmployeeDAO;
import com.jwt.model.Customer;
import com.jwt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDaoDAO;

	@Override
	public void AddCustomer(Customer cust) {

		customerDaoDAO.AddCustomer(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		customerDaoDAO.updateCustomer(cust);

	}

	@Override
	public void deleteCustomer(int id) {
		customerDaoDAO.deleteCustomer(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDaoDAO.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(int custId) {
		return customerDaoDAO.getCustomerById(custId);
	}

	@Override
	public Customer getCustomerByName(String custName) {

		return customerDaoDAO.getCustomerByName(custName);
		
	}
}
