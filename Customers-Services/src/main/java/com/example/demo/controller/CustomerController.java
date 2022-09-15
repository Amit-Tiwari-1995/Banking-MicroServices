package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.exception.InvalidCustomerException;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/test")
	public String test() {

		return "running customer-service";

	}

	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return this.customerService.getAllCustomers();
	}

	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto)
			throws InvalidCustomerException {

		ResponseEntity<Customer> customer = ResponseEntity.status(HttpStatus.CREATED)
				.body(customerService.createCustomer(customerDto));

		return customer;

	}

}
