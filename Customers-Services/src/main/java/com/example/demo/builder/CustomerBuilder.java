package com.example.demo.builder;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;

@Service
public class CustomerBuilder {

	private static String AADHAAR_REGEX = "[0-9]{12}";

	private static String MOBILE_REGEX = "[0-9]{10}";

//	private static String EMAIL_REGEX = "[0-9]{10}";

//	private static String NAME_REGEX = "(?=^.{0,40}$)^[a-zA-Z-]+\\s[a-zA-Z-]+$";

	// private String MOBILE_TICKET_REGEX = "[0-9]{10}";

	public Customer createCustomer(CustomerDto customerDto) {

		Customer customer = new Customer();

		customer.setAadhaarNumber(customerDto.getAadhaarNumber());

		customer.setBranchId(customerDto.getBranchId());
		customer.setCreatedDate(customerDto.getCreatedDate());

		customer.setDateOfBirth(customerDto.getDateOfBirth());

		// calculating age
		Instant instant = customerDto.getDateOfBirth().toInstant();

		ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());

		LocalDate givenDate = zone.toLocalDate();

		Period period = Period.between(givenDate, LocalDate.now());

		int age = period.getYears();

		if (age < 18) {
			customer.setCustomerCategory(CustomerCategoryConstant.CUSTOMER_CATEGORY_STUDENT);

		} else if (age >= 18 && age <= 60) {
			customer.setCustomerCategory(CustomerCategoryConstant.CUSTOMER_CATEGORY_REGULAR_CITIZEN);

		} else {
			customer.setCustomerCategory(CustomerCategoryConstant.CUSTOMER_CATEGORY_SENIOR_CITIZEN);

		}

		customer.setEmailAddress(customerDto.getEmailAddress());

		customer.setFirstName(customerDto.getFirstName());

		customer.setLastName(customerDto.getLastName());

		customer.setMobileNumber(customerDto.getMobileNumber());

		customer.setUpdatedDate(customerDto.getUpdatedDate());

		return customer;

	}

	public static List<String> validateCustomer(CustomerDto customerDto) {

		List<String> listErrors = new ArrayList<String>();

		ExceptionMessage exceptionMessage = new ExceptionMessage();

		if (!isValidAadhaar(customerDto.getAadhaarNumber())) {

			listErrors.add(String.format(exceptionMessage.INVALID_AADHAAR_MESSAGE + customerDto.getAadhaarNumber()));
		}

		if (!isValidEmail(customerDto.getEmailAddress())) {

			listErrors.add(String.format(exceptionMessage.INVALID_EMAIL_MESSAGE + customerDto.getEmailAddress()));
		}

		if (!isValidName(customerDto.getFirstName())) {

			listErrors.add(String.format(exceptionMessage.INVALID_FIRST_NAME_MESSAGE + customerDto.getFirstName()));
		}

		if (!isValidName(customerDto.getLastName())) {

			listErrors.add(String.format(exceptionMessage.INVALID_LAST_NAME_MESSAGE + customerDto.getLastName()));
		}

		if (!isValidMobileNumber(customerDto.getMobileNumber())) {

			listErrors.add(exceptionMessage.INVALID_MOBILE_NUMBER_MESSAGE + customerDto.getMobileNumber());
		}

		return listErrors;

	}

	public static boolean isValidAadhaar(String aadhaar) {
		if (aadhaar == null) {
			return false;
		}

		Pattern p = Pattern.compile(AADHAAR_REGEX);

		Matcher m = p.matcher(aadhaar);

		return m.matches();

	}

	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		if (name.length() == 0) {
			return false;
		}

		return true;

	}

	public static boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}
		if (email.length() == 0) {
			return false;
		}

		return true;

	}

	public static boolean isValidMobileNumber(String mobile) {
		if (mobile == null) {
			return false;
		}

		Pattern p = Pattern.compile(MOBILE_REGEX);

		Matcher m = p.matcher(mobile);

		return m.matches();

	}

}
