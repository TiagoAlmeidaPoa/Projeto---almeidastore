package com.tiago.almeidastore.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiago.almeidastore.entity.enums.PaymentStatus;

@Entity
public class BilletPayment extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dueDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date paymentDate;

	public BilletPayment() {
	}

	public BilletPayment(Integer id, PaymentStatus paymentStatus, SalesOrder salesOrder, Date dueDate, Date paymentDate) {
		super(id, paymentStatus, salesOrder);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
