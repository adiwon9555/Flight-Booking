package com.dao;

import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.dto.AirportEntity;
import com.dto.FlightEntity;
import com.dto.SpecificDateFlight;
import com.dto.Transaction;
import com.dto.CustomerEntity;

public class FlightDao implements FlightDaoInterface {

	EntityManagerFactory emf; 
	EntityManager em; 
	EntityTransaction et;
	public FlightDao() {
		this.emf=Persistence.createEntityManagerFactory("jpatest1");
		this.em=emf.createEntityManager();
		this.et=em.getTransaction(); 
	}
	
	
	public List<FlightEntity> searchFlightDAO(FlightEntity fe) {
		// TODO Auto-generated method stub
		System.out.println(fe.getSource_Airport()+" "+fe.getDestination_Airport()+" "+fe.getDays());
		Query q=em.createQuery("from com.dto.FlightEntity d where d.source_Airport=:arg1 and d.destination_Airport=:arg2 and d.days like '%"+fe.getDays()+"%'")
				.setParameter("arg1", fe.getSource_Airport()).setParameter("arg2", fe.getDestination_Airport());
		List<FlightEntity> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
		
		
	}
	
	
	public int addFlightDao(FlightEntity fu) {

		int i=0;
		try {
			et.begin();
			em.persist(fu);
			
			
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return i;
	}

	
	public int deleteFlightDao(FlightEntity fu) {
		int i=0;
		try {
			et.begin();
			Query q=em.createQuery("delete from com.dto.FlightEntity c where c.flight_No='"+fu.getFlight_No()+"'");
			i=q.executeUpdate();
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	
	public int editFlightDao(FlightEntity fu) {
		int i=0;
		try {
			et.begin();
			em.merge(fu);
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	
	public List<FlightEntity> viewAllFlightDao() {
		Query q=em.createQuery("from com.dto.FlightEntity c order by c.flight_No");
		List<FlightEntity> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}

	
	public List<FlightEntity> searchKeywordFlightDao(FlightEntity fu) {
		Query q=em.createQuery("from com.dto.FlightEntity c where c.flight_Name like '%"+fu.getFlight_Name()+"%'");
		List<FlightEntity> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}


	public List<SpecificDateFlight> getThisDateFlights(SpecificDateFlight sd,FlightEntity fe) {
		// TODO Auto-generated method stub
		//Query q=em.createQuery("from com.dto.SpecificDateFlight c where c.sdate='"+sd.getSdate()+"' and c.flight_flight_No = (select flight_No from com.dto.FlightEntity d where d.source_Airport=:arg1 and d.destination_Airport=:arg2 and d.days like '%"+fe.getDays()+"%'")
				//.setParameter("arg1", fe.getSource_Airport()).setParameter("arg2", fe.getDestination_Airport());
		Query q1=em.createQuery("from SpecificDateFlight c where c.sdate='"+sd.getSdate()+"' and c.flight in (from FlightEntity d where d.source_Airport=:one and d.destination_Airport=:two and d.days like '%"+fe.getDays()+"%')");
		q1.setParameter("one", fe.getSource_Airport());
		q1.setParameter("two", fe.getDestination_Airport());
		List<SpecificDateFlight> al=null;
		
		try {
			al=q1.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return al;
	}


	public FlightEntity getFlightByNo(FlightEntity fu) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from com.dto.FlightEntity c where c.flight_No = '"+fu.getFlight_No()+"'");
		FlightEntity al=null;
		
		try {
			al=(FlightEntity)q.getSingleResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
		
	}


	public int setTransaction(Transaction tr) {
		
		int i=0;
		try {
			et.begin();
			em.persist(tr);
			
			
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return i;
	}


	public Transaction getTransactionAfterBook(Transaction tr) {
		Query q=em.createQuery("from com.dto.Transaction c where c.sdate = '"+tr.getSdate()+"' and c.seat_no = '"+tr.getSeat_no()+"' and c.flight=:arg1")
				.setParameter("arg1", tr.getFlight());
		Transaction al=null;
		
		try {
			al=(Transaction)q.getSingleResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}


	public int setBookedFlight(SpecificDateFlight sdf) {
		
		int i=0;
		try {
			et.begin();
			em.persist(sdf);
			
			
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return i;
	}


	public SpecificDateFlight getSpecificFlight(SpecificDateFlight sdf) {
		Query q=em.createQuery("from com.dto.SpecificDateFlight c where c.sdate = '"+sdf.getSdate()+"' and c.flight=:arg1")
				.setParameter("arg1", sdf.getFlight());
		SpecificDateFlight al=null;
		
		try {
			al=(SpecificDateFlight)q.getSingleResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}


	public int updateBookedFlight(SpecificDateFlight sdf) {
		int i=0;
		try {
			et.begin();
			em.merge(sdf);
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

		

}
