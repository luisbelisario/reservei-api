package com.luis.reservei.models.enums;

public enum CourtType {

	SAIBRO(1, "SAIBRO"), GRAMA(2, "GRAMA"), CIMENTO(3, "CIMENTO");

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

	public static CourtType toEnumFromString(String courtType) {

		if (courtType == null) {
			return null;
		}
		
		String courtTypeUpper = courtType.toUpperCase();

		for (CourtType type : CourtType.values()) {
			if (type.getDescription().equals(courtTypeUpper)) {
				return type;
			}
		}

		throw new IllegalArgumentException("Tipo de quadra inválido!");
	}
	
	public static String toString(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (CourtType type : CourtType.values()) {
			if (type.getCod().equals(cod)) {
				return type.getDescription();
			}
		}
		
		throw new IllegalArgumentException("Código inválido!");
	}
}
