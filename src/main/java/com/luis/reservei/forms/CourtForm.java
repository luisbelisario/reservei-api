package com.luis.reservei.forms;

public class CourtForm {
	
	private String courtName;
	private String courtType;
	
	public CourtForm() {
		
	}

	public CourtForm(String courtName, String courtType) {
		this.courtName = courtName;
		this.courtType = courtType;
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
