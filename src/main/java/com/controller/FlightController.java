package com.controller;

import java.io.PrintWriter ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AirportDao;
import com.dao.AirportDaoInterface;
import com.dao.CustomerDao;
import com.dao.CustomerDaoInterface;
import com.dao.FlightDao;
import com.dao.FlightDaoInterface;
import com.dto.AirportEntity;
import com.dto.CustomerEntity;
import com.dto.FlightEntity;
import com.dto.SpecificDateFlight;
import com.dto.Transaction;
import com.google.gson.Gson;

@Controller
public class FlightController {
	FlightDaoInterface fd=new FlightDao();
	AirportDaoInterface ad=new AirportDao();
	@RequestMapping("/searchFlight.htm")
	public ModelAndView searchFlight(HttpServletRequest request,@RequestParam("source") String source_city,@RequestParam("destination") String destination_city,@RequestParam("date") String date)
	{
	
		
		ModelAndView mv=new ModelAndView();
		FlightEntity fe=new FlightEntity();
		
		AirportEntity ae=new AirportEntity();
		ae.setAirport_city(source_city);
		AirportEntity a1=ad.getCityDao(ae);
		fe.setSource_Airport(a1);
		
		AirportEntity ae1=new AirportEntity();
		ae1.setAirport_city(destination_city);
		AirportEntity a2=ad.getCityDao(ae1);
		fe.setDestination_Airport(a2);
		Date d=null;
		try {
			d=new SimpleDateFormat("mm/dd/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		String day=new SimpleDateFormat("EEEE").format(d);
		fe.setDays(day);
		List<FlightEntity> al=fd.searchFlightDAO(fe);
	/*	List<FlightEntity> al=new ArrayList<FlightEntity>();
		for (FlightEntity flightEntity : oal) {
			String fday[]=flightEntity.getDays().split(",");
			for(int i=0;i<fday.length;i++)
			{
				if(day.equals(fday[i]))
				{
					al.add(flightEntity);
				}
			}
		}*/
		
		String msg="";
		if(al!=null)
		{
			SpecificDateFlight sd=new SpecificDateFlight();
			sd.setSdate(date);
			List<SpecificDateFlight> lsd=fd.getThisDateFlights(sd,fe);
			List<SpecificDateFlight> final_list=new ArrayList<SpecificDateFlight>();
			
			if (lsd != null) {
				for (FlightEntity it : al) {
					int i = 0;
					for (SpecificDateFlight specificDateFlight : lsd) {
						FlightEntity temp = specificDateFlight.getFlight();
						if (temp.equals(it)) {
							i = 1;
							
							final_list.add(specificDateFlight);
							break;
						}
					}
					if (i == 0) {
						SpecificDateFlight f_o = new SpecificDateFlight();
						f_o.setAvailable_seats(15);
						f_o.setFlight(it);
						f_o.setSdate(date);
						final_list.add(f_o);
					}
				}

			} else {
				
				for (FlightEntity it : al) {
					System.out.println("Adityassadfsa");
					SpecificDateFlight f_o = new SpecificDateFlight();
					System.out.println("new");
					
					f_o.setAvailable_seats(15);
					f_o.setFlight(it);
					f_o.setSdate(date);
					final_list.add(f_o);
				}
			}
			
			
			mv.addObject("specific_flight_list", final_list);
		
			mv.setViewName("Booking_table.jsp");
		}
		else
		{
			msg="No Flights";
			mv.setViewName("Temp_message.jsp");
		}	
		return mv;
	}
	
	@RequestMapping("/addFlight.htm")
	public ModelAndView addFlight(@RequestParam("flight_Name") String flight_Name,@RequestParam("departure_Time") String departure_Time,@RequestParam("arrival_Time") String arrival_Time,
			@RequestParam("flight_Price") String flight_Price,@RequestParam("source") String source_Airport,@RequestParam("destination") String destination_Airport,HttpServletRequest request)
	{
		String days=String.join(",", request.getParameterValues("days"));
		
		ModelAndView mv=new ModelAndView();   
		FlightEntity fu=new FlightEntity();
		AirportEntity ae=new AirportEntity();
		ae.setAirport_city(source_Airport);
		AirportEntity source_airportEntity=ad.getCityDao(ae);
		AirportEntity ae1=new AirportEntity();
		ae1.setAirport_city(destination_Airport);
		AirportEntity destination_airportEntity=ad.getCityDao(ae1);
		
		
		fu.setFlight_Name(flight_Name);
		fu.setFlight_Price(Long.parseLong(flight_Price));
		fu.setArrival_Time(arrival_Time);
		fu.setDeparture_Time(departure_Time);
		fu.setSource_Airport(source_airportEntity);
		fu.setDestination_Airport(destination_airportEntity);
		fu.setDays(days);
		int i=fd.addFlightDao(fu);
		String msg="";
		if(i>0)
			{
				msg="Added Successfully";
			}
		else
			{
				msg="not Added Successfully";
			}
			
			
		
		                                     
		mv.addObject("temp_message",msg);
		mv.setViewName("Flight_List.jsp");
		return mv;
	}
	
	@RequestMapping("/deleteFlight.htm")
	public ModelAndView deleteFlight(@RequestParam("flight_No") long flight_No)
	{
		ModelAndView mv=new ModelAndView();
		FlightEntity fu=new FlightEntity();
		fu.setFlight_No(flight_No);
		int i=fd.deleteFlightDao(fu);
		String msg="";
		if(i>0)
		{
			msg="Flight Removed";
			
		}
		else
		{
			msg="There was a problem in removing Flight";
			
		}
		mv.addObject("temp_message", msg);
		mv.setViewName("Flight_List.jsp");
		return mv;
	}
	@RequestMapping("/editFlight.htm")
	public ModelAndView editFlight(@RequestParam("flight_No") long flight_No,@RequestParam("flight_Name") String flight_Name,@RequestParam("departure_Time") String departure_Time,@RequestParam("arrival_Time") String arrival_Time,
			@RequestParam("flight_Price") String flight_Price,@RequestParam("source") String source_Airport,@RequestParam("destination") String destination_Airport,HttpServletRequest request)
	{
		String days=String.join(",", request.getParameterValues("days"));
		ModelAndView mv=new ModelAndView();   
		FlightEntity fu=new FlightEntity();
		AirportEntity ae=new AirportEntity();
		ae.setAirport_city(source_Airport);
		AirportEntity source_airportEntity=ad.getCityDao(ae);
		AirportEntity ae1=new AirportEntity();
		ae1.setAirport_city(destination_Airport);
		AirportEntity destination_airportEntity=ad.getCityDao(ae1);
		
		fu.setFlight_No(flight_No);
		fu.setFlight_Name(flight_Name);
		fu.setFlight_Price(Long.parseLong(flight_Price));
		fu.setDeparture_Time(departure_Time);
		fu.setArrival_Time(arrival_Time);
		fu.setSource_Airport(source_airportEntity);
		fu.setSource_Airport(source_airportEntity);
		fu.setDestination_Airport(destination_airportEntity);
		fu.setDays(days);
		int i=fd.editFlightDao(fu);
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
		mv.setViewName("Flight_List.jsp");
		return mv;
	}
	@RequestMapping("/viewAllFlight.htm")
	public ModelAndView viewAllFlight()
	{
		ModelAndView mv=new ModelAndView();
		List<FlightEntity> ff=null;
		ff=fd.viewAllFlightDao();
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
	@RequestMapping("/searchKeywordFlight.htm")
	public ModelAndView searchKeywordFlight(@RequestParam("search") String flight_Name)
	{
		ModelAndView mv=new ModelAndView();
		
		FlightEntity fu=new FlightEntity();
		fu.setFlight_Name(flight_Name);
		List<FlightEntity> ff=null;
		ff=fd.searchKeywordFlightDao(fu);
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
	@RequestMapping("/getFlightByNo.htm")
	public ModelAndView getFlightByNo(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		long flight_No=Long.parseLong(request.getParameter("flight_No"));
		FlightEntity fu=new FlightEntity();
		fu.setFlight_No(flight_No);
		FlightEntity ff=null;
		ff=fd.getFlightByNo(fu);
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
	
	
	@RequestMapping("/book.htm")
	public ModelAndView book(@RequestParam("sdate") String sdate,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();

		long available_seats=Long.parseLong(request.getParameter("available_seats"));
		
		long flight_No=Long.parseLong(request.getParameter("flight_No"));
		FlightEntity fu=new FlightEntity();
		fu.setFlight_No(flight_No);
		FlightEntity ff=null;
		ff=fd.getFlightByNo(fu);
		String msg="";
		if(ff!=null)
		{
			msg="Retrival Successfull";
			mv.addObject("temp_message",msg);
			mv.addObject("sdate",sdate);
			mv.addObject("available_seats",available_seats);
			mv.addObject("flight",ff);
			mv.setViewName("Passenger_details.jsp");
			
			
		
		}
		else
		{
			msg="Retrival not Successfull";
			mv.addObject("temp_message",msg);
			mv.setViewName("Booking_table.jsp");
		}
		
		return mv;
	}
	
	
	@RequestMapping("/toPayment.htm")
	public ModelAndView toPayment(@RequestParam("sdate") String sdate,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		long amount_paid=Long.parseLong(request.getParameter("amount_paid"));
		long available_seats=Long.parseLong(request.getParameter("available_seats"));
		String passengers=request.getParameter("passengers");
		
		long flight_No=Long.parseLong(request.getParameter("flight_No"));
		FlightEntity fu=new FlightEntity();
		fu.setFlight_No(flight_No);
		FlightEntity ff=null;
		ff=fd.getFlightByNo(fu);
		String msg="";
		if(ff!=null)
		{
			mv.addObject("passengers",passengers);
			mv.addObject("sdate",sdate);
			mv.addObject("amount_paid",amount_paid);
			mv.addObject("available_seats",available_seats);
			mv.addObject("flight",ff);
			mv.setViewName("payment.jsp");
			
			
		
		}
		else
		{
			msg="Some error occured";
			mv.addObject("temp_message",msg);
			mv.setViewName("Temp_message.jsp");
		}
		
		return mv;
	}
	
	
	
	@RequestMapping("/final_book.htm")
	public ModelAndView final_book(@RequestParam("sdate") String sdate,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		HttpSession sc=request.getSession();
		CustomerEntity customer=(CustomerEntity)sc.getAttribute("user");
		long flight_No=Long.parseLong(request.getParameter("flight_No"));
		long available_seats=Long.parseLong(request.getParameter("available_seats"));
		long amount_paid=Long.parseLong(request.getParameter("amount_paid"));
		String passengers=request.getParameter("passengers");
		
		FlightEntity fu=new FlightEntity();
		fu.setFlight_No(flight_No);
		FlightEntity flight=null;
		flight=fd.getFlightByNo(fu);
		long seats_taken=amount_paid/(flight.getFlight_Price());
		Transaction tr=new Transaction();
		tr.setAmount_paid(amount_paid);
		tr.setCustomer(customer);
		tr.setFlight(flight);
		tr.setPassengers(passengers);
		tr.setSdate(sdate);
		tr.setSeats_taken(seats_taken);
		tr.setSeat_no(available_seats);
		int i=fd.setTransaction(tr);
		Transaction ntr=fd.getTransactionAfterBook(tr);
		
		
		String msg="";
		if(ntr!=null)
		{
			SpecificDateFlight sdf=new SpecificDateFlight();
			
			sdf.setAvailable_seats(available_seats-seats_taken);
			sdf.setFlight(flight);
			sdf.setSdate(sdate);
			SpecificDateFlight stemp=fd.getSpecificFlight(sdf);
			int j=0;
			if(stemp==null)
			{
			 j=fd.setBookedFlight(sdf);
			}
			else
			{
				sdf.setSid(stemp.getSid());
			j=fd.updateBookedFlight(sdf);
			}
			mv.addObject("transaction_details",ntr);
			msg="Retrival Successfull";
			mv.addObject("temp_message",msg);
			mv.setViewName("Ticket.jsp");
			
			
		
		}
		else
		{
			msg="Ticket already Booked";
			mv.addObject("temp_message",msg);
			mv.setViewName("Temp_message.jsp");
		}
		
		return mv;
	}
	
	
						
}



