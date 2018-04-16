package com.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FlightEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long flight_No;
	private String flight_Name;
	private String departure_Time;
	private String arrival_Time;
	private String days;
	
	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	private long flight_Price;
	@ManyToOne
	private AirportEntity source_Airport;
	
	@ManyToOne
	private AirportEntity destination_Airport;

	public long getFlight_No() {
		return flight_No;
	}

	public void setFlight_No(long flight_No) {
		this.flight_No = flight_No;
	}

	public String getFlight_Name() {
		return flight_Name;
	}

	public void setFlight_Name(String flight_Name) {
		this.flight_Name = flight_Name;
	}

	

	public String getDeparture_Time() {
		return departure_Time;
	}

	public void setDeparture_Time(String departure_Time) {
		this.departure_Time = departure_Time;
	}

	public String getArrival_Time() {
		return arrival_Time;
	}

	public void setArrival_Time(String arrival_Time) {
		this.arrival_Time = arrival_Time;
	}

	

	public long getFlight_Price() {
		return flight_Price;
	}

	public void setFlight_Price(long flight_Price) {
		this.flight_Price = flight_Price;
	}

	public AirportEntity getSource_Airport() {
		return source_Airport;
	}

	public void setSource_Airport(AirportEntity source_Airport) {
		this.source_Airport = source_Airport;
	}

	public AirportEntity getDestination_Airport() {
		return destination_Airport;
	}

	public void setDestination_Airport(AirportEntity destination_Airport) {
		this.destination_Airport = destination_Airport;
	}
	
	
		
		
}
