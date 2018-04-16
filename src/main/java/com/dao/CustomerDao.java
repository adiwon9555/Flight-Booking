package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.AirportEntity;
import com.dto.CustomerEntity;
import com.dto.Transaction;

public class CustomerDao implements CustomerDaoInterface {
	EntityManagerFactory emf; 
	EntityManager em; 
	EntityTransaction et;
	public CustomerDao() {
		this.emf=Persistence.createEntityManagerFactory("jpatest1");
		this.em=emf.createEntityManager();
		this.et=em.getTransaction(); 
	}
	
	public int createProfileDAO(CustomerEntity fu)
	{
		
	
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
	public int editProfileDAO(CustomerEntity fu)
	{
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
	public int deleteProfileDAO(CustomerEntity fu)
	{
		
		int i=0;
		try {
			et.begin();
			
			Query q=em.createQuery("delete from com.dto.CustomerEntity c where c.id='"+fu.getId()+"'");
			i=q.executeUpdate();
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}
	public CustomerEntity viewProfileDAO(CustomerEntity fu)
	{
		

		Query q=em.createQuery("from com.dto.CustomerEntity c where c.email='"+fu.getEmail()+"' and c.password='"+fu.getPassword()+"'");
		CustomerEntity al=null;
		
		try {
			al=(CustomerEntity) q.getSingleResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
		
	}
	public boolean validateEmailDAO(CustomerEntity fu) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from com.dto.CustomerEntity c where c.email='"+fu.getEmail()+"'");
		CustomerEntity al=null;
		boolean flag=false;
		try {
			al=(CustomerEntity) q.getSingleResult();
			
				
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		if(al!=null)
		{
			flag=true;
		}
	
		
		return flag;
	}
	public boolean validatePhoneDAO(CustomerEntity fu) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from com.dto.CustomerEntity c where c.phone='"+fu.getPhone()+"'");
		CustomerEntity al=null;
		boolean flag=false;
		try {
			al=(CustomerEntity) q.getSingleResult();
			
				
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		if(al!=null)
		{
			flag=true;
		}
	
		
		return flag;
	}
	
	
	public List<CustomerEntity> viewAllCustomerDao() {
		Query q=em.createQuery("from com.dto.CustomerEntity c order by c.id");
		List<CustomerEntity> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}

	public List<Transaction> viewAllTransactionDao() {
		Query q=em.createQuery("from com.dto.Transaction c order by c.id");
		List<Transaction> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}

	public int deleteTransactionDAO(Transaction ce) {
		int i=0;
		try {
			et.begin();
			
			Query q=em.createQuery("delete from com.dto.Transaction c where c.transaction_id='"+ce.getTransaction_id()+"'");
			i=q.executeUpdate();
			et.commit();
			i=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public List<Transaction> viewMyTransactionDao(CustomerEntity ce) {
		Query q=em.createQuery("from com.dto.Transaction c where c.customer=:arg1 order by c.transaction_id ").setParameter("arg1", ce);
		List<Transaction> al=null;
		
		try {
			al=q.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return al;
	}
	
	
	
	
	

}
