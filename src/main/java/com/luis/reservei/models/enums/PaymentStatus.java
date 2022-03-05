package com.luis.reservei.models.enums;

public enum PaymentStatus {
	
	PAGA(1, "Paga"),
	PENDENTE(2, "Pendente");
	
	private Integer cod;
	private String description;
	
	PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static PaymentStatus toEnum(Integer cod) {
		 if (cod == null) {
			 return null;
		 }
		 
		 for (PaymentStatus status : PaymentStatus.values()) {
			 if (status.getCod().equals(cod)) {
				 return status;
			 }
		 }
		 
		 throw new IllegalArgumentException("Código inválido!");
	}
}
