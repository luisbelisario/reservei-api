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

import com.luis.reservei.dtos.CourtDTO;
import com.luis.reservei.forms.CourtForm;
import com.luis.reservei.models.Court;
import com.luis.reservei.services.CourtService;

@RestController
@RequestMapping(value = "/courts")
public class CourtController {
	
	@Autowired
	private CourtService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CourtDTO>> findAll() {
		
		List<Court> list = service.findAll();
		List<CourtDTO> listDto = list.stream().map(obj -> service.fromCourt(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<Void> create(@Valid @RequestBody CourtForm form) {
		
		service.create(form);
		
		return ResponseEntity.ok().build();
	}
}
