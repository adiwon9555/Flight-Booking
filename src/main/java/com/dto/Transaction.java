package com.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transaction_id;
	@ManyToOne
	private CustomerEntity customer;
	@ManyToOne
	private FlightEntity flight;
	
	private String sdate;
	private String passengers;
	private long amount_paid;
	private long seat_no;
	private long seats_taken;
	
	public String getPassengers() {
		return passengers;
	}
	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}
	public long getSeats_taken() {
		return seats_taken;
	}
	public void setSeats_taken(long seats_taken) {
		this.seats_taken = seats_taken;
	}
	public long getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(long amount_paid) {
		this.amount_paid = amount_paid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	public long getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(long seat_no) {
		this.seat_no = seat_no;
	}
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public FlightEntity getFlight() {
		return flight;
	}
	public void setFlight(FlightEntity flight) {
		this.flight = flight;
	}
	

}
