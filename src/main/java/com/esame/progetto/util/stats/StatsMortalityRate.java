package com.esame.progetto.util.stats;

import java.util.ArrayList;
import java.util.Collections;

import com.esame.progetto.model.InfoCountry;
import com.esame.progetto.model.ResponseSummary;


public class StatsMortalityRate{
	
	public int percRate(InfoCountry c)
	{
		int  ConfTot=Integer.parseInt(c.getTotConfirmed());
		int DeathsTot=Integer.parseInt(c.getTotDeaths());
		return (DeathsTot/ConfTot)*100;
	}
	public Integer mortalityRate(ResponseSummary countries)
	{
		ArrayList<Integer> countriesRate = null;
		
		
			for(InfoCountry c : countries.getCountries())
			{
					countriesRate.add(percRate(c));
				
			}
			System.out.println("il paese con il maggior tasso di mortalità è:");
			return Collections.max(countriesRate);
		}
		
		
		
	}
	

