package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.builder.CustomerBuilder;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.exception.InvalidCustomerException;
import com.example.demo.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

	@Autowired
	private CustomerBuilder customerBuilder;

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return this.customerRepository.findAll();

	}

	public Customer createCustomer(CustomerDto customerDto) throws InvalidCustomerException{

		
		List<String> validateErrors=CustomerBuilder.validateCustomer(customerDto);
		if(validateErrors.size() > 0)
		{
			  throw new InvalidCustomerException(validateErrors.toString());
		}
		
			
		
		Customer customer = customerBuilder.createCustomer(customerDto);

		return this.customerRepository.save(customer);

	}

}
