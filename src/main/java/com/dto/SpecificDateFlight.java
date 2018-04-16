package com.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class SpecificDateFlight implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long sid;
	
	private String sdate;
	
	@ManyToOne
	private FlightEntity flight;
	private long available_seats;
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public FlightEntity getFlight() {
		return flight;
	}
	public void setFlight(FlightEntity flight) {
		this.flight = flight;
	}
	public long getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(long available_seats) {
		this.available_seats = available_seats;
	}
}
