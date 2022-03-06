package com.luis.reservei.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientForm {
	
	@NotNull(message = "Nome não pode ser vazio") @NotEmpty
	private String name;
	
	@NotNull(message = "Cpf não pode ser vazio") @NotEmpty
	private String cpf;
	
	private String phoneNumber;
	
	public ClientForm() {
		
	}

	public ClientForm(String name, String cpf, String phoneNumber) {
		this.name = name;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
