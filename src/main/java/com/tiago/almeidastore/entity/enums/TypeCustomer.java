package com.tiago.almeidastore.entity.enums;

public enum TypeCustomer {
	
	NATURALPERSON(1, "Natural Person"),
	LEGALPERSON(2, "Legal person");
	
	private int code;
	private String description;
	
	private TypeCustomer(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static TypeCustomer toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(TypeCustomer typeCustomer: TypeCustomer.values()) {
			if(code.equals(typeCustomer.getCode())) {
				return typeCustomer;
			}
		}
		
		throw new IllegalArgumentException("Invalid code: "+code);
	}
	

}
