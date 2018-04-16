package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.dto.AirportEntity;

public interface AirportDaoInterface {
	public int addAirportDao(AirportEntity city);
	public int deleteAirportDao(AirportEntity city);
	public int editAirportDao(AirportEntity city);
	public List<AirportEntity> viewAllAirportDao();
	public List<AirportEntity> searchAirportDao(AirportEntity city);
	public AirportEntity getCityDao(AirportEntity city);
	public List<AirportEntity> getCitiesDao(AirportEntity city);
}
