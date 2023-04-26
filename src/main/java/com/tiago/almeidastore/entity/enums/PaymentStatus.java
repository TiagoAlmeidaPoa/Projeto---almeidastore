package com.tiago.almeidastore.entity.enums;

public enum PaymentStatus {
	
	PENDING(1, "pending"),
	FINISHED(2, "finished"),
	CANCELED(2, "canceled");
	
	private int code;
	private String description;
	
	private PaymentStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(PaymentStatus paymentStatus: PaymentStatus.values()) {
			if(code.equals(paymentStatus.getCode())) {
				return paymentStatus;
			}
		}
		
		throw new IllegalArgumentException("Invalid code: "+code);
	}
	

}
