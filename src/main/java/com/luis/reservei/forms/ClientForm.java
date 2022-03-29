package com.luis.reservei.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientForm {
	
	@Email @NotNull(message = "Email não pode ser vazio") @NotEmpty
	private String email;
	
	@NotNull(message = "Senha não pode ser vazia") @NotEmpty
	private String password;
	
	@NotNull(message = "Nome não pode ser vazio") @NotEmpty
	private String name;
	
	@NotNull(message = "Cpf não pode ser vazio") @NotEmpty
	private String cpf;
	
	private String phoneNumber;
	
	public ClientForm() {
		
	}

	public ClientForm(String email, String password, String name, String cpf, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
