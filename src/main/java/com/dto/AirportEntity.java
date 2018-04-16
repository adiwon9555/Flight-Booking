package com.dto;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
@Entity
public class AirportEntity implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long airport_id;
	@Column(unique=true)
	private String airport_name;
	@Column(unique=true)
	private String airport_city;
	@Column(unique=true)
	private String airport_short_name;
	
	
	

	public long getAirport_id() {
		return airport_id;
	}
	public void setAirport_id(long airport_id) {
		this.airport_id = airport_id;
	}
	public String getAirport_short_name() {
		return airport_short_name;
	}
	public void setAirport_short_name(String airport_short_name) {
		this.airport_short_name = airport_short_name;
	}
	public String getAirport_name() {
		return airport_name;
	}
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
	public String getAirport_city() {
		return airport_city;
	}
	public void setAirport_city(String airport_city) {
		this.airport_city = airport_city;
	}
}
