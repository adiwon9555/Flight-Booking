package com.controller;

import java.util.List ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.BookingDao;
import com.dao.BookingDaoInterfae;
import com.dao.CustomerDao;
import com.dao.CustomerDaoInterface;
import com.dao.FlightDao;
import com.dao.FlightDaoInterface;
import com.dto.AirportEntity;
import com.dto.CustomerEntity;
import com.dto.FlightEntity;
import com.dto.SpecificDateFlight;
import com.google.gson.Gson;

@Controller
public class BookingAdminController {
	
	FlightDaoInterface fd=new FlightDao();
	BookingDaoInterfae bd=new BookingDao();
	@RequestMapping("/addBooking.htm")
	public ModelAndView register_profile(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		long flight_No=Long.parseLong(request.getParameter("flight_No"));
		String sdate=request.getParameter("sdate");
		long available_seats=Long.parseLong(request.getParameter("available_seats"));
		FlightEntity fe=new FlightEntity();
		fe.setFlight_No(flight_No);
		FlightEntity ff=fd.getFlightByNo(fe);
		
				
		SpecificDateFlight fu=new SpecificDateFlight();
		
		fu.setFlight(ff);
		fu.setSdate(sdate);
		fu.setAvailable_seats(available_seats);
		
		
	
			int i=bd.addBookingDAO(fu);
			String msg="";
			if(i>0)
			{
				msg="Added Successful";
				
			}
			else
			{
				msg="Not added Successful";
				
			
			}
			mv.addObject("temp_message", msg);
			mv.setViewName("Booking_List.jsp");
			
			
		
		return mv;
		
		
	}
	@RequestMapping("/deleteBooking.htm")
	public ModelAndView delete_profle(@RequestParam("sid") long sid)
	{
		ModelAndView mv=new ModelAndView();
		SpecificDateFlight ce=new SpecificDateFlight();
		ce.setSid(sid);
		int i=bd.deleteBookingDAO(ce);
		String msg="";
		if(i>0)
		{
			msg="Booking deleted";
			
		}
		else
		{
			msg="There was a problem in deleting Booking";
			
		}
		mv.addObject("temp_message", msg);
		mv.setViewName("Booking_List.jsp");
		return mv;
	}
	@RequestMapping("/editBooking.htm")
	public ModelAndView update_profile(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		long sid=Long.parseLong(request.getParameter("sid"));
		long flight_No=Long.parseLong(request.getParameter("flight_No"));
		String sdate=request.getParameter("sdate");
		long available_seats=Long.parseLong(request.getParameter("available_seats"));
		FlightEntity fe=new FlightEntity();
		fe.setFlight_No(flight_No);
		FlightEntity ff=fd.getFlightByNo(fe);
		
				
		SpecificDateFlight fu=new SpecificDateFlight();
		fu.setSid(sid);
		fu.setFlight(ff);
		fu.setSdate(sdate);
		fu.setAvailable_seats(available_seats);
		
		
	
			int i=bd.editBookingDAO(fu);
			String msg="";
			if(i>0)
			{
				msg="Edited Successfully";
				
			}
			else
			{
				msg="Not Edited Successfully";
				
			
			}
			mv.addObject("temp_message", msg);
			mv.setViewName("Booking_List.jsp");
			
			
		
		return mv;
	}
	
	
	@RequestMapping("/viewAllBooking.htm")
	public ModelAndView viewAllBooking()
	{
		ModelAndView mv=new ModelAndView();
		List<SpecificDateFlight> ff=null;
		ff=bd.viewAllBookingDao();
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
