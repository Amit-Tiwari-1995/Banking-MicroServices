package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(generator = "id_seq")
	@SequenceGenerator(name = "id_seq",sequenceName = "id_seq",initialValue = 1001,allocationSize = 2)
	private int customerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "branch_id")
	private int branchId;
	@Column(name = "customer_category")
	private String customerCategory;
	@Column(name = "aadhaar_number")
	private String aadhaarNumber;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "updated_date")
	private Date updatedDate;

}
