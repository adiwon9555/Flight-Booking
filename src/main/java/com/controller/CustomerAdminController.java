package com.controller;

import java.util.List ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dao.CustomerDao;
import com.dao.CustomerDaoInterface;
import com.dto.AirportEntity;
import com.dto.CustomerEntity;
import com.dto.Transaction;
import com.google.gson.Gson;

@Controller
public class CustomerAdminController {
	
	CustomerDaoInterface fd=new CustomerDao();
	@RequestMapping("/addCustomer.htm")
	public ModelAndView register_profile(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		
				
		CustomerEntity fu=new CustomerEntity();
		
		fu.setName(name);
		fu.setPassword(password);
		fu.setAddress(address);
		fu.setAge(age);
		fu.setCountry(country);
		fu.setState(state);
		fu.setDob(dob);
		fu.setEmail(email);
		fu.setGender(gender);
		fu.setPhone(phone);;
		
		
	
			int i=fd.createProfileDAO(fu);
			String msg="";
			if(i>0)
			{
				msg="Registration Successful";
				
			}
			else
			{
				msg="Registration not Successful";
				
			
			}
			mv.addObject("temp_message", msg);
			mv.setViewName("Customer_List.jsp");
			
			
		
		return mv;
		
		
	}
	@RequestMapping("/deleteCustomer.htm")
	public ModelAndView delete_profle(@RequestParam("id") long id)
	{
		ModelAndView mv=new ModelAndView();
		CustomerEntity ce=new CustomerEntity();
		ce.setId(id);
		int i=fd.deleteProfileDAO(ce);
		String msg="";
		if(i>0)
		{
			msg="Profile deleted";
			
		}
		else
		{
			msg="There was a problem in deleting account";
			
		}
		mv.addObject("temp_message", msg);
		mv.setViewName("Customer_List.jsp");
		return mv;
	}
	
	
	
	@RequestMapping("/deleteTransaction.htm")
	public ModelAndView deleteTransaction(@RequestParam("transaction_id") long transaction_id)
	{
		ModelAndView mv=new ModelAndView();
		Transaction ce=new Transaction();
		ce.setTransaction_id(transaction_id);
		int i=fd.deleteTransactionDAO(ce);
		String msg="";
		if(i>0)
		{
			msg="Transaction deleted";
			
		}
		else
		{
			msg="There was a problem in deleting Transaction";
			
		}
		mv.addObject("temp_message", msg);
		mv.setViewName("Transaction_List.jsp");
		return mv;
	}
	
	
	
	
	@RequestMapping("/editCustomer.htm")
	public ModelAndView update_profile(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String country=request.getParameter("country");
		String phone=request.getParameter("phone");
		String state=request.getParameter("state");
		String gender=request.getParameter("gender");
		long id=Long.parseLong(request.getParameter("id"));		
		CustomerEntity fu=new CustomerEntity();
		
		
		fu.setName(name);
		fu.setPassword(password);
		fu.setAddress(address);
		fu.setAge(age);
		fu.setCountry(country);
		fu.setState(state);
		fu.setDob(dob);
		fu.setEmail(email);
		fu.setGender(gender);
		fu.setPhone(phone);
		fu.setId(id);
		
		try {
			int i=fd.editProfileDAO(fu);
			String msg="";
			if(i>0)
			{
				msg="Update Successful";
			}
			else
			{
				msg="Update not Successful";
			}
			
			mv.addObject("temp_message", msg);
			mv.setViewName("Customer_List.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	@RequestMapping("/viewAllCustomer.htm")
	public ModelAndView viewAllCustomer()
	{
		ModelAndView mv=new ModelAndView();
		List<CustomerEntity> ff=null;
		ff=fd.viewAllCustomerDao();
		String msg="";
		if(ff!=null)
		{
			
			Gson gson = new Gson();
			msg= gson.toJson(ff);
			
			
		
		}
		else
		{
			msg="Retrival not Successfull";
		}
		mv.addObject("temp_message",msg);
		mv.setViewName("Temp_message.jsp");
		return mv;
	}
	@RequestMapping("/viewAllTransaction.htm")
	public ModelAndView viewAllTransaction()
	{
		ModelAndView mv=new ModelAndView();
		List<Transaction> ff=null;
		ff=fd.viewAllTransactionDao();
		String msg="";
		if(ff!=null)
		{
			
			Gson gson = new Gson();
			msg= gson.toJson(ff);
			
			
		
		}
		else
		{
			msg="Retrival not Successfull";
		}
		mv.addObject("temp_message",msg);
		mv.setViewName("Temp_message.jsp");
		return mv;
	}
	
	
/*	@RequestMapping("/validate_email")
	public ModelAndView validate_email(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String email=request.getParameter("email");
		
		CustomerEntity fu=new CustomerEntity();
		fu.setEmail(email);
		
		
		boolean flag=false;
		
		flag=fd.validateEmailDAO(fu);
		System.out.println("hello");
		//ServletContext sc=getServletContext();
		//HttpSession sc=request.getSession(true);
		
		String msg="";
		if(flag==false)
		{
			
			msg="";
			mv.addObject("temp_message",msg);
			mv.setViewName("Temp_message.jsp");
		}
		else
		{
			msg="Email already exist";
			mv.addObject("temp_message",msg);
			mv.setViewName("Temp_message.jsp");
		}
		return mv;
	}
	@RequestMapping("validate_phone")
	public ModelAndView validate_phone(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String phone=request.getParameter("phone");
		
		CustomerEntity fu=new CustomerEntity();
		fu.setPhone(phone);
		
		
		boolean flag=false;
		
		flag=fd.validatePhoneDAO(fu);
		System.out.println("hello");
		//ServletContext sc=getServletContext();
		//HttpSession sc=request.getSession(true);
		String msg="";
		if(flag==false)
		{
			msg="";
			mv.addObject("temp_message",msg);
			mv.setViewName("Temp_message.jsp");
		}
		else
		{
			msg="Phone already exist";
			mv.addObject("temp_message",msg);
			mv.setViewName("Temp_message.jsp");
		}
		return mv;
	}
*/
}
