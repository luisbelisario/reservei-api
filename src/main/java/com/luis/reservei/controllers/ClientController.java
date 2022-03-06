package com.luis.reservei.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luis.reservei.dtos.ClientDTO;
import com.luis.reservei.forms.ClientForm;
import com.luis.reservei.models.Client;
import com.luis.reservei.services.ClientService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> findAll() {
		
		List<Client> list = service.findAll();
		List<ClientDTO> listDto = list.stream().map(obj -> service.fromClient(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<Void> create(@Valid @RequestBody ClientForm form) {
		
		Client client = service.fromForm(form);
		
		service.create(client);
		
		return ResponseEntity.ok().build();
	}
}
