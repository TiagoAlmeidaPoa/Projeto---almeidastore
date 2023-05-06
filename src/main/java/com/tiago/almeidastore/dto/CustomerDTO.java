package com.tiago.almeidastore.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.tiago.almeidastore.entity.Customer;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Completion is mandatory ! ")
	@Length(min = 3, max = 80, message = "Length must be between 3 and 80 characters")
	private String name;
	
	@NotEmpty(message = "Completion is mandatory ! ")
	@Email(message = "Invalid Email")
	private String email;

	public CustomerDTO() {
	}

	public CustomerDTO(Customer obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
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

}
