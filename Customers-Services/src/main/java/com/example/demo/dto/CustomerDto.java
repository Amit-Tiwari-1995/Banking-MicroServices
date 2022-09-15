
package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1382792906741654576L;
	
	private String firstName;
	private String lastName;
	private String emailAddress;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateOfBirth;
	
	private String mobileNumber;
	private int branchId;
	private String customerCategory;
	private String aadhaarNumber;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date createdDate;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date updatedDate;

}
