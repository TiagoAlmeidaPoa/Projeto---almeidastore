package com.tiago.almeidastore.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tiago.almeidastore.controller.exception.FieldMessage;
import com.tiago.almeidastore.dto.CustomerNewDTO;
import com.tiago.almeidastore.entity.enums.TypeCustomer;
import com.tiago.almeidastore.service.validation.utils.BR;

public class CustomerInsertValidator implements ConstraintValidator<CustomerInsert, CustomerNewDTO> {
	@Override
	public void initialize(CustomerInsert ann) {
	}

	@Override
	public boolean isValid(CustomerNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTypeCustomer().equals(TypeCustomer.NATURALPERSON.getCode()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "Invalid CPF"));
		}
		
		if(objDto.getTypeCustomer().equals(TypeCustomer.LEGALPERSON.getCode()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "Invalid CNPJ"));
		}

		// inclua os testes aqui, inserindo erros na lista

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
