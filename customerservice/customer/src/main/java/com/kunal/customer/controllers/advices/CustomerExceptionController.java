package com.kunal.customer.controllers.advices;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kunal.customer.errorresponse.APIError;
import com.kunal.customer.exception.CustomerNotFoundException;


@ControllerAdvice
public class CustomerExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerExceptionController.class);
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="NotFound occured")
	public @ResponseBody APIError handleSQLException(HttpServletRequest request, Exception ex) {
		logger.error("Not Found exception");
		APIError error = new APIError(HttpStatus.NOT_FOUND,ex);
		return error;
	}

}
