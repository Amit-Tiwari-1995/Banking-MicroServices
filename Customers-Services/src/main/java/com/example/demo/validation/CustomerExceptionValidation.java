
package com.example.demo.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidCustomerException;

@RestControllerAdvice
public class CustomerExceptionValidation {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	Map<String, List<String>> invalidCustomerExceptionValidtion(InvalidCustomerException ex) {
		Map<String, List<String>> mapErrors = new HashMap<String, List<String>>();
		List<String> listErrors = new ArrayList<String>();
		listErrors.add(ex.getMessage());

		mapErrors.put("errorMessages", listErrors);
		return mapErrors;
	}

}
