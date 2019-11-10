package com.alansari.customer.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alansari.customer.dao.CustomerDao;
import com.alansari.customer.persistence.Customer;

@Service
public class CustomerService /* implements CustomerService */{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CustomerDao dao;
	
	public void addCustomer(Customer user) {
		logger.info("Adding customer "+user.getFirstName());
		dao.addCustomer(user);
	}

	public List<Customer> getCustomer() {
		logger.info("Getting customer ");
		return dao.getCustomer();
	}

	public Customer findById(int id) {
		logger.info("Getting customer "+id);
		return dao.findById(id);
	}

	public Customer update(Customer user, int id) {
		return dao.update(user, id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

}
