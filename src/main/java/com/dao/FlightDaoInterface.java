package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.FlightEntity;
import com.dto.SpecificDateFlight;
import com.dto.Transaction;
import com.dto.FlightEntity;
import com.dto.CustomerEntity;

public interface FlightDaoInterface {
	public int addFlightDao(FlightEntity city);
	public int deleteFlightDao(FlightEntity city);
	public int editFlightDao(FlightEntity city);
	public List<FlightEntity> viewAllFlightDao();
	public List<FlightEntity> searchKeywordFlightDao(FlightEntity city);
	public List<FlightEntity> searchFlightDAO(FlightEntity fe);
	public List<SpecificDateFlight> getThisDateFlights(SpecificDateFlight sd,FlightEntity fe);
	public FlightEntity getFlightByNo(FlightEntity fu);
	public int setTransaction(Transaction tr);
	public Transaction getTransactionAfterBook(Transaction tr);
	public int setBookedFlight(SpecificDateFlight sdf);
	public SpecificDateFlight getSpecificFlight(SpecificDateFlight sdf);
	public int updateBookedFlight(SpecificDateFlight sdf);

	
}
