package com.kunal.customer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.kunal.customer.persistence.Customer;


//@Repository
//public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	/*
	 * 
	 * List<Customer> customerList = new ArrayList<Customer>();
	 * 
	 * { Customer customer1 = new Customer(123,"Kunal","Kumar","D170"); Customer
	 * customer2 = new Customer(124,"Kanak","Kumar","D171"); Customer customer3 =
	 * new Customer(125,"Sachin","Kumar","D172"); Customer customer4 = new
	 * Customer(126,"Hitesh","Kumar","D173"); Customer customer5 = new
	 * Customer(127,"Tarun","Kumar","D174"); customerList.add(customer1);
	 * customerList.add(customer2); customerList.add(customer3);
	 * customerList.add(customer4); customerList.add(customer5); }
	 * 
	 * @Override public <S extends Customer> S save(S entity) {
	 * customerList.add(entity); return entity; }
	 * 
	 * @Override public <S extends Customer> Iterable<S> saveAll(Iterable<S>
	 * entities) { entities.forEach(e -> customerList.add(e)); return entities; }
	 * 
	 * @Override public Optional<Customer> findById(Integer id) { return
	 * customerList.stream().filter(e -> e.getId().equals(id)).findFirst(); }
	 * 
	 * @Override public boolean existsById(Integer id) { return
	 * customerList.stream().anyMatch(e -> e.getId().equals(id)); }
	 * 
	 * @Override public Iterable<Customer> findAll() { return customerList; }
	 * 
	 * @Override public Iterable<Customer> findAllById(Iterable<Integer> ids) {
	 * List<Customer> customerListResult = new ArrayList<Customer>(); for(Customer
	 * customer: customerList) { for(Integer i: ids) {
	 * if(i.equals(customer.getId())) { customerListResult.add(customer); } } }
	 * return customerListResult; }
	 * 
	 * @Override public long count() { // TODO Auto-generated method stub return
	 * customerList.size(); }
	 * 
	 * @Override public void deleteById(Integer id) { customerList.removeIf(e ->
	 * e.getId().equals(id)); }
	 * 
	 * @Override public void delete(Customer entity) { customerList.remove(entity);
	 * }
	 * 
	 * @Override public void deleteAll(Iterable<? extends Customer> entities) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 *///}
