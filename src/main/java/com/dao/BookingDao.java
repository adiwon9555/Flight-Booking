package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.CustomerEntity;
import com.dto.SpecificDateFlight;

public class BookingDao implements BookingDaoInterfae {
	
	EntityManagerFactory emf; 
	EntityManager em; 
	EntityTransaction et;
	public BookingDao() {
		this.emf=Persistence.createEntityManagerFactory("jpatest1");
		this.em=emf.createEntityManager();
		this.et=em.getTransaction(); 
	}
	
	public int addBookingDAO(SpecificDateFlight fu) {

		int i=0;
		try {
			et.begin();
			em.persist(fu);
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return i;
		}
		
		return i;
	}

	public int deleteBookingDAO(SpecificDateFlight ce) {
		int i=0;
		try {
			et.begin();
			
			Query q=em.createQuery("delete from com.dto.SpecificDateFlight c where c.sid='"+ce.getSid()+"'");
			i=q.executeUpdate();
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int editBookingDAO(SpecificDateFlight fu) {
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

	public List<SpecificDateFlight> viewAllBookingDao() {
		Query q=em.createQuery("from com.dto.SpecificDateFlight c order by c.sid");
		List<SpecificDateFlight> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}
}
