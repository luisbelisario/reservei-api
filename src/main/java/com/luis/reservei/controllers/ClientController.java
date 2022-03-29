package com.luis.reservei.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @RequestBody ClientForm form, UriComponentsBuilder uriBuilder) {
		
		Client client = service.update(form, id);
		ClientDTO clientDto = service.fromClient(client);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).body(clientDto);
	}
	
	
}
