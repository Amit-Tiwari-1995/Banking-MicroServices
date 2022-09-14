package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private int ticketId;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "requested_email_addess")
	private String requestedEmailAddress;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "ticket_message")
	private String ticketMessage;

	@Column(name = "assigned_to")
	private long assignedTo;

	@Column(name = "status")
	private String status;

	@Column(name = "created_date", columnDefinition = "DATETIME")
	@CreationTimestamp
	private Date createdDate;

	@Column(name = "udpated_date", columnDefinition = "DATETIME")
	@UpdateTimestamp
	private Date updatedDate;

}
