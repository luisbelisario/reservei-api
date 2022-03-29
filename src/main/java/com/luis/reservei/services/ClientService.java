package com.luis.reservei.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.reservei.dtos.ClientDTO;
import com.luis.reservei.forms.ClientForm;
import com.luis.reservei.models.Client;
import com.luis.reservei.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repo;
	
	public List<Client> findAll() {
		return repo.findAll();
	}
	
	public Client create(Client client) {
		client.setId(null);
		return repo.save(client);
	}
	
	public Client update(ClientForm form, Integer id) {
		Client client = repo.findById(id).get();
		client.setEmail(form.getEmail());
		client.setPassword(form.getPassword());
		client.setName(form.getName());
		client.setCpf(form.getCpf());
		client.setPhoneNumber(form.getPhoneNumber());
		return repo.save(client);
	}
	
	public Client fromForm(ClientForm form) {
		return new Client(form.getName(), form.getEmail(), form.getPassword(), form.getCpf(), form.getPhoneNumber());
	}
	
	public ClientDTO fromClient(Client client) {
		return new ClientDTO(client.getId(), client.getEmail(), client.getName(), client.getCpf(), client.getPhoneNumber(), client.getCreatedAt());
	}
}
