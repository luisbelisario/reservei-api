package com.luis.reservei.models.enums;

public enum CourtType {

	SAIBRO(1, "Saibro"),
	GRAMA(2, "Grama"),
	CIMENTO(3, "Cimento");

	private Integer cod;
	private String description;

	private CourtType(Integer cod, String description) {
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
	
	public static CourtType toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (CourtType type : CourtType.values()) {
			if (type.getCod().equals(cod)) {
				return type;
			}
		}
		
		throw new IllegalArgumentException("Código inválido!");
	}
}
