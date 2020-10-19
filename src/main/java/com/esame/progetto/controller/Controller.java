package com.esame.progetto.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esame.progetto.data.JsonParser;
import com.esame.progetto.model.InfoCountry;
import com.esame.progetto.model.InfoDayOne;
import com.esame.progetto.model.ResponseSummary;
import com.esame.progetto.util.filter.CountryBody;
import com.esame.progetto.util.service.DayOneServiceImpl;
import com.esame.progetto.util.service.SummaryServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Classe che gestisce le chiamate di tipo <code>GET</code> o <code>POST</code>
 * per l'utilizzo di determinate rotte.
 * 
 * @author Dediu Alexandru
 *
 */
@RestController
public class Controller {
	@Autowired
	private SummaryServiceImpl summaryService;
	@Autowired
	private DayOneServiceImpl dayOneService;
	
	
	
	
	/**
	 *
	 *
	 * Questo metodo gestisce la rotta <code>"/data/summary"</code> 
	 * che utilizza una chiamata di tipo <code>GET</code>.
	 * Restituisce  tutti i dati contenuti nel <code>JSON</code>
	 * convertiti in oggetti di tipo <code>InfoCountry</code>.
	 * 
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 * @return ArrayLiist che contiene oggetti <code>InfoCountry</code>
	 * 
	 */
	@RequestMapping(value = "/data/summary", method = RequestMethod.GET)
	public ArrayList<InfoCountry> summaryRequest() throws JsonMappingException, JsonProcessingException
	{
		
		return summaryService.getSummaryData();
		
		
	}
	/**
	 * Questo metodo gestisce la rotta <code>"/data/dayone"</code>
	 * che utilizza una chiamata di tipo <code>POST</code>.
	 * Restituisce tutti i dati contenuti del <code>JSON</code>
	 * convertiti in oggetti di tipo <code>InfoDayOne</code>.
	 * 
	 * 
	 * 
	 * @param country stringa inserita dall'utente per selezionare il paese.
	 * @return List di oggetti di tipo <code>InfoDayOne</code>.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@RequestMapping(value="/data/dayone",method=RequestMethod.POST)
	public List<InfoDayOne> dayOneRequest( @RequestBody String  country) throws MalformedURLException, IOException
	{
		ObjectMapper obj= new ObjectMapper();
		 CountryBody  c =obj.readValue(country, CountryBody.class);
		 CountryBody countryBody= new CountryBody(c.getCountryName());
		
		return dayOneService.getDayOneData(countryBody.getCountryName());
		
		
	}
	
	/**
	 * Questo metodo gestisce la rotta <code>"/stats"</code>
	 * che utilizza una chiamata di tipo <code>GET</code>.
	 * Restituisce le statistiche effettuate  su un dataset.
	 */
	@RequestMapping(value="/stats/", method = RequestMethod.GET)
	public void statsRequest()
	{
		
	}
	/**
	 * Questo metodo gestisce la rotta <code>"/stats/countries"</code>
	 * che utilizza una chiamata di tipo <code>POST</code>.
	 * Restituisce una statistica effettuta su un dataset con paesi selezionati dall'utente.
	 * 
	 * @param body : paesi inseriti dall'utente.
	 */
	@RequestMapping(value="/stats/countries", method= RequestMethod.POST)
	public  void statsByCountries(@RequestBody  String body)
	{
		
	}
	
	

}
