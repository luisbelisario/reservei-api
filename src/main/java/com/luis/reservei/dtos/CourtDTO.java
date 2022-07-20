package com.luis.reservei.dtos;

import com.luis.reservei.models.enums.CourtType;

public class CourtDTO {
	
	private Integer id;
	private String courtName;
	private String courtType;
	
	public CourtDTO() {

	}

	public CourtDTO(Integer id, String courtName, Integer courtType) {
		this.id = id;
		this.courtName = courtName;
		this.courtType = CourtType.toString(courtType);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getCourtType() {
		return courtType;
	}

	public void setCourtType(String courtType) {
		this.courtType = courtType;
	}
	
}
