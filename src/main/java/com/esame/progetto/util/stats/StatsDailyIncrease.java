package com.esame.progetto.util.stats;

import java.util.ArrayList;
import java.util.Calendar;

import com.esame.progetto.model.ContainerResponseDayOne;
import com.esame.progetto.model.ResponseDayOne;

public class StatsDailyIncrease {
	
	public int growthRate(int a,int b)
	{
		return ((b-a)/a)*100;
	}
	public void dailyIncrease(ContainerResponseDayOne response,String keyword)
	{
		ArrayList<Calendar> dates= new ArrayList<Calendar>();
		ArrayList<Integer> listValue= new ArrayList<Integer>();
		
		for(ResponseDayOne r : response.getResponse())
		{
			if( r.getCountryName().equals(keyword))
			{dates.add(r.dateStringinDateObj(r.getDate()));
			listValue.add(Integer.parseInt(r.getnDeaths()));}
			
		}
		System.out.println("i tassi di crescita giornalieri dalla data "+ dates.get(0) + "sono : ");
		for(int i = 0; i< listValue.size();i++)
		{
			if( i < i-1)
			{
			System.out.println(i + "." + "il tasso è diminuito del " +  growthRate(i-1,i) + "%");
			}
			else if( i > i-1)
			{
			System.out.println(i + "." +"il tasso è aumentato del " + growthRate(i-1,i) + "%");
			}
				
			}
			{
		}
		
		
		
		
		
		
		
		
	}

	
	

	

}
