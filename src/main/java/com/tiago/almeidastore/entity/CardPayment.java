package com.tiago.almeidastore.entity;

import javax.persistence.Entity;

import com.tiago.almeidastore.entity.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer numberInstallments;

	public CardPayment() {
	}

	public CardPayment(Integer id, PaymentStatus paymentStatus, SalesOrder salesOrder, Integer numberInstallments) {
		super(id, paymentStatus, salesOrder);
		this.numberInstallments = numberInstallments;
	}

	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}

}
