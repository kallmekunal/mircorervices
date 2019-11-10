package com.alansari.customer.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alansari.customer.persistence.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDao{
		
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomer() {
		return sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Override
	public Customer findById(int id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public Customer update(Customer customer, int id) {
		Customer customerInDB = sessionFactory.getCurrentSession().find(Customer.class, id);
		customerInDB.setAddress(customer.getAddress());
		customerInDB.setFirstName(customer.getFirstName());
		sessionFactory.getCurrentSession().save(customer);
		return customer;
	}

	/*
	 * @Override public Customer updateCountry(Customer customer, int id) { Customer
	 * customerInDB = sessionFactory.getCurrentSession().find(Customer.class, id);
	 * customerInDB.setAddress(customer.getAddress());
	 * customerInDB.setFirstName(customer.getFirstName());
	 * sessionFactory.getCurrentSession().save(customer); return customer; }
	 */

	@Override
	public void delete(int id) {
		Customer customerInDB = sessionFactory.getCurrentSession().find(Customer.class, id);
		sessionFactory.getCurrentSession().delete(customerInDB);
	}
}
