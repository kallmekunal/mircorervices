package com.kunal.customer.dao;

import java.util.List;

import com.kunal.customer.persistence.Customer;

public interface CustomerDao {
    public void addCustomer(Customer user);
    public List<Customer> getCustomer();
    public Customer findById(int id);
    public Customer update(Customer user, int id);
    public void delete(int id);
}