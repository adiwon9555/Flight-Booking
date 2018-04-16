/*package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FlightDao;
import com.dao.FlightDaoInterface;
import com.dto.AirportEntity;
import com.dto.CityEntity;
import com.dto.FlightEntity;
import com.google.gson.Gson;
import com.dto.CustomerEntity;


@WebServlet("/GlobalServletController")
public class GlobalServletController extends HttpServlet {
	FlightDaoInterface fd=new FlightDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getParameter("action");
		if(action.equals("searchFlight"))
		{
			FlightEntity fe=new FlightEntity();
			String source_city=request.getParameter("source");
			String destination_city=request.getParameter("destination");
			CityEntity city1=new CityEntity();
			city1.setCity_name(source_city);
			CityEntity c=fd.getCityDao(city1);
			fe.setSource_city(c);
			CityEntity city2=new CityEntity();
			city2.setCity_name(destination_city);
			CityEntity c1=fd.getCityDao(city2);
			
			fe.setDestination_city(c1);;
			
			
			List<FlightEntity> al=fd.searchFlightDAO(fe);
			String msg="";
			if(al!=null)
			{
				request.setAttribute("flight_list", al);
				
				msg="Retrival Successfull";
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Source_Destination.jsp");
				rd.forward(request, response);
				
			
				
			
			}
			else
			{
				msg="Retrival unsuccessful";
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Source_Destination.jsp");
				rd.include(request, response);
			}
			
			
			
			
		}
		
		
		if(action.equals("getCity"))
		{
			String city_name=request.getParameter("city_name");
			
			CityEntity city=new CityEntity();
			city.setCity_name(city_name);
			List<CityEntity> al=fd.getCitiesDao(city);
			List<String> ls = new ArrayList<String>();
			
			PrintWriter out=response.getWriter();
			if(al!=null)
			{
				for (CityEntity c : al) {
					ls.add(c.getCity_name());
				}
				
				Gson gson = new Gson();
				String json = gson.toJson(ls);
				out.println(json);
				
			}
			else
			{
				out.println("[\"no city\"]");
			}
			
			
			
			
		}
		
		
		
		
		if(action.equals("register_profile"))
		{
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			//String age=request.getParameter("age");
			//String address=request.getParameter("address");
			String email=request.getParameter("email");
			String dob=request.getParameter("dob");
			//String country=request.getParameter("country");
			//String state=request.getParameter("state");
			String gender=request.getParameter("gender");
			String phone=request.getParameter("phone");
			
					
			CustomerEntity fu=new CustomerEntity();
			
			fu.setName(name);
			fu.setPassword(password);
			//fu.setAddress(address);
			//fu.setAge(age);
			//fu.setCountry(country);
			//fu.setState(state);
			fu.setDob(dob);
			fu.setEmail(email);
			fu.setGender(gender);
			fu.setPhone(phone);;
			
			FlightDaoInterface fd=new FlightDao();
			try {
				int i=fd.createProfileDAO(fu);
				String msg="";
				if(i>0)
				{
					msg="Registration Successful, Please Login to continue..";
					request.setAttribute("message", msg);
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				else
				{
					msg="Registration not Successful,Try again..";
					request.setAttribute("message", msg);
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if(action.equals("login"))
		{
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			CustomerEntity fu=new CustomerEntity();
			fu.setEmail(email);
			fu.setPassword(password);
			FlightDaoInterface fd=new FlightDao();
			CustomerEntity ff=null;
			
			ff=fd.viewProfileDAO(fu);
			System.out.println("hello");
			//ServletContext sc=getServletContext();
			HttpSession sc=request.getSession(true);
			
			String msg="";
			if(ff!=null)
			{
				request.setAttribute("email", email);
				sc.setAttribute("user", ff);
				msg="Login Successfull";
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/first1.jsp");
				rd.forward(request, response);
				
			
				
			
			}
			else
			{
				msg="Wrong Credentials!! Try Again..";
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			}
			
		}
		if(action.equals("delete_profle"))
		{
			HttpSession sc=request.getSession();
			CustomerEntity fu=(CustomerEntity) sc.getAttribute("user");
			
			FlightDao fd=new FlightDao();
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
			request.setAttribute("dmessage", msg);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/Delete.jsp");
			rd.forward(request, response);
		}
		if(action.equals("update_profile"))
		{
			HttpSession session=request.getSession();
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String age=request.getParameter("age");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String dob=request.getParameter("dob");
			String country=request.getParameter("country");
			String state=request.getParameter("state");
			String gender=request.getParameter("gender");
			String image=request.getParameter("image");
			String hob[]=request.getParameterValues("hob");
			CustomerEntity user=(CustomerEntity) session.getAttribute("user");
			long id=user.getId();
					
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
			fu.setId(id);
			FlightDaoInterface fd=new FlightDao();
			try {
				int i=fd.editProfileDAO(fu);
				String msg="";
				if(i>0)
				{
					session.setAttribute("user", fu);
					msg="Update Successful";
				}
				else
				{
					msg="Update not Successful";
				}
				
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login1.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(action.equals("validate_email"))
		{
			
			String email=request.getParameter("email");
			
			CustomerEntity fu=new CustomerEntity();
			fu.setEmail(email);
			
			
			boolean flag=false;
			
			flag=fd.validateEmailDAO(fu);
			System.out.println("hello");
			//ServletContext sc=getServletContext();
			//HttpSession sc=request.getSession(true);
			PrintWriter out=response.getWriter();
			String msg="";
			if(flag==false)
			{
				
				msg=email;
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login1.jsp");
				rd.forward(request, response);
				
				out.println(msg);
				
			
				
			
			}
			else
			{
				msg="Email already exist";
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login1.jsp");
				rd.forward(request, response);
				
				out.println(msg);
			}
			
		}
		if(action.equals("validate_phone"))
		{
			
			String phone=request.getParameter("phone");
			
			CustomerEntity fu=new CustomerEntity();
			fu.setPhone(phone);
			
			
			boolean flag=false;
			
			flag=fd.validatePhoneDAO(fu);
			System.out.println("hello");
			//ServletContext sc=getServletContext();
			//HttpSession sc=request.getSession(true);
			PrintWriter out=response.getWriter();
			String msg="";
			if(flag==false)
			{
				
				msg="";
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login1.jsp");
				rd.forward(request, response);
				
				out.println(msg);
				
			
				
			
			}
			else
			{
				msg="Phone already exist";
				request.setAttribute("message", msg);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login1.jsp");
				rd.forward(request, response);
				
				out.println(msg);
			}
			
		}
						
	}
	

}
*/