package com.tiago.almeidastore.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.tiago.almeidastore.service.validation.CustomerInsert;

@CustomerInsert
public class CustomerNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Completion is mandatory ! ")
	@Length(min = 3, max = 80, message = "Length must be between 3 and 80 characters")
	private String name;
	
	@NotEmpty(message = "Completion is mandatory ! ")
	@Email(message = "Invalid Email")
	private String email;
	
	@NotEmpty(message = "Completion is mandatory ! ")
	private String cpfOrCnpj;
	
	private Integer typeCustomer;

	@NotEmpty(message = "Completion is mandatory ! ")
	private String street;
	
	@NotEmpty(message = "Completion is mandatory ! ")
	private String number;
	
	private String complement;
	
	private String district;
	
	@NotEmpty(message = "Completion is mandatory ! ")
	private String zipCode;

	@NotEmpty(message = "Completion is mandatory ! ")
	private String phone1;
	
	private String phone2;
	
	private String phone3;

	private Integer cityId;

	public CustomerNewDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public Integer getTypeCustomer() {
		return typeCustomer;
	}

	public void setTypeCustomer(Integer typeCustomer) {
		this.typeCustomer = typeCustomer;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}
