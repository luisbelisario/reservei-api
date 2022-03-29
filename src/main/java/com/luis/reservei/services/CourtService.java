package com.luis.reservei.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.reservei.dtos.CourtDTO;
import com.luis.reservei.forms.CourtForm;
import com.luis.reservei.models.Court;
import com.luis.reservei.models.enums.CourtType;
import com.luis.reservei.repositories.CourtRepository;

@Service
public class CourtService {
	
	@Autowired
	CourtRepository repo;
	
	public List<Court> findAll() {
		return repo.findAll();
	}
	
	public Court create(CourtForm courtForm) {
		Court court = fromForm(courtForm);
		return repo.save(court);
	}
	
	public Court fromForm(CourtForm form) {
		CourtType courtType = CourtType.toEnumFromString(form.getCourtType());
		return new Court(null, form.getCourtName(), courtType);
	}

	public CourtDTO fromCourt(Court court) {
		return new CourtDTO(court.getId(), court.getCourtName(), court.getCourtType().getCod());
	}
	
}
