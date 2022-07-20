package com.luis.reservei.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.luis.reservei.models.enums.CourtType;

@Entity
public class Court {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String courtName;
	private Integer courtType;
	
	@OneToMany(mappedBy = "court")
	List<Reservation> reservations = new ArrayList<>();
	
	public Court() {
		
	}
	
	public Court(Integer id, String courtName, CourtType courtType) {
		this.id = id;
		this.courtName = courtName;
		this.courtType = (courtType == null) ? null : courtType.getCod();
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

	public CourtType getCourtType() {
		return CourtType.toEnum(courtType);
	}

	public void setCourtType(CourtType courtType) {
		this.courtType = courtType.getCod();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Court other = (Court) obj;
		return Objects.equals(id, other.id);
	}
	
}
