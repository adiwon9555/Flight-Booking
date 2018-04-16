package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.dto.CustomerEntity;
import com.dto.Transaction;

public interface CustomerDaoInterface {
	public int createProfileDAO(CustomerEntity fu);
	public int editProfileDAO(CustomerEntity fu);
	public int deleteProfileDAO(CustomerEntity fu);
	public CustomerEntity viewProfileDAO(CustomerEntity fu);
	public boolean validateEmailDAO(CustomerEntity fu);
	public boolean validatePhoneDAO(CustomerEntity fu);
	public List<CustomerEntity> viewAllCustomerDao();
	public List<Transaction> viewAllTransactionDao();
	public int deleteTransactionDAO(Transaction ce);
	public List<Transaction> viewMyTransactionDao(CustomerEntity ce);
}
