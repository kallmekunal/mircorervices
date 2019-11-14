package com.kunal.customer.controllers;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kunal.customer.dto.CustomerDTO;
import com.kunal.customer.errorresponse.APIError;
import com.kunal.customer.exception.CustomerNotFoundException;
import com.kunal.customer.persistence.Customer;
import com.kunal.customer.services.CustomerService;

@RestController
@RequestMapping(value="/customerservice/v1")
public class CustomerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * @Autowired CustomerRepository myRepository;
	 */
	@Autowired
	CustomerService myRepository;

	@GetMapping
	(path="/customer/{id}")
	public @ResponseBody Customer getCustomer(@PathVariable("id") Integer id) {
		logger.info("Got request for getCustomer for {}",id);
//		 return myRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
		Customer customer= myRepository.findById(id);
		if (null !=customer) {
			return customer;
		}else {throw new CustomerNotFoundException();}
	}
	
	@PostMapping
	(path = "/customer")
	public @ResponseBody Customer createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		logger.info("Creating customer with name  {}",customerDTO.getFirstName());
		Customer customer = new Customer(customerDTO.getId(),customerDTO.getFirstName(),customerDTO.getLastName(),null);
		myRepository.addCustomer(customer);
		return customer;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody APIError handleNotFoundException(Exception e) {
		APIError error = new APIError(HttpStatus.NOT_FOUND,e);
		return error;
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public @ResponseBody APIError handleMethodArgumentNotValidException(Exception e) {
		APIError error = new APIError(HttpStatus.BAD_REQUEST,e);
		error.setMessage(e.getMessage());
		return error;
		
	}
}
