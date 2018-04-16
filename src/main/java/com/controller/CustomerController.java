package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dao.CustomerDao;
import com.dao.CustomerDaoInterface;
import com.dto.CustomerEntity;
import com.dto.Transaction;
import com.google.gson.Gson;

@Controller
public class CustomerController {
	
	CustomerDaoInterface fd=new CustomerDao();
	@RequestMapping("/register_profile.htm")
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
		
		
		try {
			int i=fd.createProfileDAO(fu);
			String msg="";
			if(i>0)
			{
				msg="Registration Successful, Please Login to continue..";
				mv.addObject("message", msg);
				mv.setViewName("index.jsp");
			}
			else
			{
				msg="Registration not Successful,Try again..";
				
				mv.addObject("message", msg);
				mv.setViewName("index.jsp");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
		
		
	}
	@RequestMapping("/login.htm")
	public ModelAndView login(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		
		
		HttpSession sc=request.getSession(false);
		if(sc==null)
		{
			mv.addObject("message", "Login First");
			mv.setViewName("index.jsp");
			return mv;
		}
		sc=request.getSession();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals("admin@itc.com") && password.equals("admin"))
		{
			mv.setViewName("admin.jsp");
			return mv;
		}
		
		
		CustomerEntity fu=new CustomerEntity();
		fu.setEmail(email);
		fu.setPassword(password);
		
		CustomerEntity ff=null;
		
		ff=fd.viewProfileDAO(fu);
		System.out.println("hello");
		
		
		String msg="";
		if(ff!=null)
		{
			sc.setAttribute("user", ff);
			msg=ff.getName();
			mv.addObject("message", msg);
			mv.setViewName("first1.jsp");
		}
		else
		{
			msg="Wrong Credentials!! Try Again..";
			
			mv.addObject("message", msg);
			mv.setViewName("index.jsp");
		}
		return mv;
	}
		@RequestMapping("/logout.htm")
		public ModelAndView logout(HttpServletRequest request)
		{
			ModelAndView mv=new ModelAndView();
			HttpSession sc=request.getSession();
			sc.invalidate();
			
			mv.setViewName("index.jsp");
			
			return mv;
	}
	@RequestMapping("/delete_profle.htm")
	public ModelAndView delete_profle(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		HttpSession sc=request.getSession();
		CustomerEntity fu=(CustomerEntity) sc.getAttribute("user");
		
		
		int i=fd.deleteProfileDAO(fu);
		String msg="";
		if(i>0)
		{
			msg="Profile deleted";
			
		}
		else
		{
			msg="There was a problem in deleting account";
			
		}
		mv.addObject("dmessage", msg);
		mv.setViewName("Delete.jsp");
		return mv;
	}
	@RequestMapping("/update_profile.htm")
	public ModelAndView update_profile(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String age= request.getParameter("age");
		
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String phone=request.getParameter("phone");
		String gender=request.getParameter("gender");
		
	
		
		long id=Long.parseLong(request.getParameter("id"));
				
		CustomerEntity fu=new CustomerEntity();
		fu.setName(name);
		fu.setPassword(password);
		fu.setAge(age);
		fu.setDob(dob);
		fu.setEmail(email);
		fu.setGender(gender);
		fu.setId(id);
		fu.setPhone(phone);
		
	
			int i=fd.editProfileDAO(fu);
			String msg="";
			String cust="";
			if(i>0)
			{
				
				session.removeAttribute("user");
				session.setAttribute("user", fu);
				msg="Update Successful";
				Gson gson=new Gson();
				 cust=gson.toJson(fu);
			}
			else
			{
				msg="Update not Successful";
			}
			
			mv.addObject("temp_message", msg);
			mv.addObject("cust",cust);
			mv.setViewName("Temp_message.jsp");
	
		return mv;
	}
	@RequestMapping("/validate_email")
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
	
	@RequestMapping("/viewMyTransaction.htm")
	public ModelAndView viewMyTransaction(HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		CustomerEntity ce=(CustomerEntity)session.getAttribute("user");
		List<Transaction> ff=null;
		
		ff=fd.viewMyTransactionDao(ce);
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
	
	

}
