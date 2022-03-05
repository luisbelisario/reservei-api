package com.luis.reservei.models;

import static com.luis.reservei.utils.DateUtils.toDate;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.luis.reservei.models.enums.PaymentStatus;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "court_id")
	private Court court;
	
	private Date reservationDate;
	
	@Column(name = "duration_in_hours")
	private Integer timeDuration;
	
	private Integer status;

	public Reservation() {
		
	}

	public Reservation(Client client, Court court, String reservationDate, Integer timeDuration, PaymentStatus status) throws ParseException {
		this.client = client;
		this.court = court;
		this.reservationDate = toDate(reservationDate);
		this.timeDuration = timeDuration;
		this.status = (status == null) ? null : status.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}
	
	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) throws ParseException {
		this.reservationDate = toDate(reservationDate);
	}

	public Integer getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(Integer timeDuration) {
		this.timeDuration = timeDuration;
	}
	
	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setStatus(PaymentStatus status) {
		this.status = status.getCod();
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}	
	
}
