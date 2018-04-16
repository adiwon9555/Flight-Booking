package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AirportDao;
import com.dao.AirportDaoInterface;
import com.dto.AirportEntity;
import com.google.gson.Gson;



@Controller
public class AirportController {
	AirportDaoInterface fd=new AirportDao();
	
	@RequestMapping("/getCity.htm")
	public ModelAndView getCity(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String city_name=request.getParameter("city_name");
		
		AirportEntity city=new AirportEntity();
		city.setAirport_city(city_name);
		List<AirportEntity> al=fd.getCitiesDao(city);
		List<String> ls = new ArrayList<String>();
		
		
		if(al!=null)
		{
			for (AirportEntity c : al) {
				ls.add(c.getAirport_city());
			}
			
			Gson gson = new Gson();
			String json = gson.toJson(ls);
			mv.addObject("temp_message",json);
			mv.setViewName("Temp_message.jsp");
			
		}
		else
		{
			mv.addObject("temp_message","no message");
			mv.setViewName("Temp_message.jsp");
		}
		return mv;
	}
	@RequestMapping("/addAirport.htm")
	public ModelAndView addAirport(@RequestParam("airport_name") String airport_name,@RequestParam("airport_city") String airport_city,
			@RequestParam("airport_short_name") String airport_short_name)
	{
		ModelAndView mv=new ModelAndView();   
		AirportEntity fu=new AirportEntity();
		fu.setAirport_name(airport_name);
		fu.setAirport_city(airport_city);
		fu.setAirport_short_name(airport_short_name);	
		int i=fd.addAirportDao(fu);
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
		mv.setViewName("Airport_List.jsp");
		return mv;
	}
	
	@RequestMapping("/deleteAirport.htm")
	public ModelAndView deleteAirport(@RequestParam("airport_id") long airport_id)
	{
		ModelAndView mv=new ModelAndView();
		AirportEntity fu=new AirportEntity();
		fu.setAirport_id(airport_id);
		int i=fd.deleteAirportDao(fu);
		String msg="";
		if(i>0)
		{
			msg="Airport Removed";
			
		}
		else
		{
			msg="There was a problem in removing airport";
			
		}
		mv.addObject("temp_message", msg);
		mv.setViewName("Airport_List.jsp");
		return mv;
	}
	@RequestMapping("/editAirport.htm")
	public ModelAndView editAirport(@RequestParam("airport_id") long airport_id,@RequestParam("airport_name") String airport_name,@RequestParam("airport_city") String airport_city,
			@RequestParam("airport_short_name") String airport_short_name)
	{
		ModelAndView mv=new ModelAndView();
		AirportEntity fu=new AirportEntity();
		fu.setAirport_id(airport_id);
		fu.setAirport_name(airport_name);
		fu.setAirport_city(airport_city);
		fu.setAirport_short_name(airport_short_name);	
		int i=fd.editAirportDao(fu);
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
		mv.setViewName("Airport_List.jsp");
		return mv;
	}
	@RequestMapping("/viewAllAirport.htm")
	public ModelAndView viewAllAirport()
	{
		ModelAndView mv=new ModelAndView();
		List<AirportEntity> ff=null;
		ff=fd.viewAllAirportDao();
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
	@RequestMapping("/searchAirport.htm")
	public ModelAndView searchAirport(@RequestParam("search") String airport_city)
	{
		ModelAndView mv=new ModelAndView();
		
		AirportEntity fu=new AirportEntity();
		fu.setAirport_city(airport_city);
		List<AirportEntity> ff=null;
		ff=fd.searchAirportDao(fu);
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
