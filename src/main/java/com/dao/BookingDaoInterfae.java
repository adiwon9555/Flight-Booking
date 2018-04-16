package com.dao;

import java.util.List;

import com.dto.SpecificDateFlight;

public interface BookingDaoInterfae {

	public int addBookingDAO(SpecificDateFlight fu) ;

	public int deleteBookingDAO(SpecificDateFlight ce);

	public int editBookingDAO(SpecificDateFlight fu) ;

	public List<SpecificDateFlight> viewAllBookingDao() ;

}
