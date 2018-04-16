package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.AirportEntity;
import com.dto.CustomerEntity;

public class AirportDao implements AirportDaoInterface{
	EntityManagerFactory emf; 
	EntityManager em; 
	EntityTransaction et;
	public AirportDao() {
		this.emf=Persistence.createEntityManagerFactory("jpatest1");
		this.em=emf.createEntityManager();
		this.et=em.getTransaction(); 
	}
	
	public AirportEntity getCityDao(AirportEntity city)
	{
		

		Query q=em.createQuery("from com.dto.AirportEntity c where c.airport_city ='"+city.getAirport_city()+"'");
		AirportEntity al=null;
		
		try {
			al=(AirportEntity)q.getSingleResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
		
	}
	public List<AirportEntity> getCitiesDao(AirportEntity city)
	{
		

		Query q=em.createQuery("from com.dto.AirportEntity c where c.airport_city like '"+city.getAirport_city()+"%'");
		List<AirportEntity> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
		
	}

	public int addAirportDao(AirportEntity fu) {

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

	public int deleteAirportDao(AirportEntity fu) {
		int i=0;
		try {
			et.begin();
			Query q=em.createQuery("delete from com.dto.AirportEntity c where c.airport_id='"+fu.getAirport_id()+"'");
			i=q.executeUpdate();
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int editAirportDao(AirportEntity fu) {
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

	
	public List<AirportEntity> viewAllAirportDao() {
		Query q=em.createQuery("from com.dto.AirportEntity c order by c.airport_id");
		List<AirportEntity> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}

	
	public List<AirportEntity> searchAirportDao(AirportEntity fu) {
		Query q=em.createQuery("from com.dto.AirportEntity c where c.airport_city like '%"+fu.getAirport_city()+"%'");
		List<AirportEntity> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}
	
}
