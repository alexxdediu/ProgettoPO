package com.esame.progetto.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.esame.progetto.model.InfoCountry;
import com.esame.progetto.model.InfoDayOne;
import com.esame.progetto.model.MortRateConfModel;
import com.esame.progetto.util.service.DayOneServiceImpl;
import com.esame.progetto.util.service.SummaryServiceImpl;
import com.esame.progetto.exceptions.BodyException;
import com.esame.progetto.exceptions.ServiceException;
import com.esame.progetto.model.CountriesBody;
import com.esame.progetto.model.DailyIncreaseModel;
import com.esame.progetto.model.MortalityRateModel;

import com.esame.progetto.util.stats.StatsDailyIncrease;
import com.esame.progetto.util.stats.StatsMortalityRate;
import com.esame.progetto.util.stats.StatsMortalityRateConf;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Classe che gestisce le chiamate di tipo <code>GET</code> o <code>POST</code>
 * per l'utilizzo di determinate rotte.
 * 
 * @author Alexandru Dediu
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
	 * @see {@link com.esame.progetto.util.service.SummaryServiceImpl#getSummaryData()}
	 * 
	 */
	@RequestMapping(value = "/data/summary", method = RequestMethod.GET)
	public ArrayList<InfoCountry> summaryRequest() throws JsonMappingException, JsonProcessingException
	{
		return summaryService.getSummaryData();
		
	}
	/**
	 * Questo metodo gestisce la rotta <code>"/data/dayone/{coutry}"</code>
	 * che utilizza una chiamata di tipo <code>GET</code>.
	 * Restituisce tutti i dati contenuti nel <code>JSON</code>
	 * convertiti in oggetti di tipo <code>InfoDayOne</code>.
	 * 
	 * 
	 * 
	 * @param country : stringa inserita dall'utente per selezionare il paese.
	 * @return List di oggetti di tipo <code>InfoDayOne</code>.
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ServiceException 
	 * @see {@link com.esame.progetto.util.service.DayOneServiceImpl#getDayOneData(String)}
	 */
	@RequestMapping(value="/data/dayone/{country}",method=RequestMethod.GET)
	public  List<InfoDayOne> dayOneRequest( @PathVariable ("country") String country) throws MalformedURLException, IOException, ServiceException 
	{
		
			return dayOneService.getDayOneData(country);
		
	}
	
	/**
	 * Questo metodo gestisce la rotta <code>"/stats/dayone/{country}"</code>
	 * che utilizza una chiamata di tipo <code>GET</code>.
	 * Restituisce un <code>ArrayList</code> di oggetti di tipo <code>DailyIncreaseModel</code>,
	 * ogni oggetto contiene il range delle date in cui è stata effettuata la statistica
	 * e il tasso di incremento giornaliero in percentuale.
	 * 
	 * @param country :  stringa inserita dall'utente per selezionare il paese.
	 * @return  <code>ArrayList</code> di oggetti di tipo <code>DailyIncreaseModel</code> analizzati.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws ServiceException 
	 * @see {@link com.esame.progetto.util.stats.StatsDailyIncrease#dailyIncrease(List)}
	 */
	@RequestMapping(value="/stats/dayone/{country}", method = RequestMethod.GET)
	public ArrayList<DailyIncreaseModel> statsDailyIncreaseRequest(@PathVariable ("country") String country) throws MalformedURLException, IOException, ServiceException
	{
		StatsDailyIncrease stats= new StatsDailyIncrease();
		List<InfoDayOne> list = dayOneService.getDayOneData(country);
		 return stats.dailyIncrease(list);
	
	}
	/**
	 * Questo metodo gestisce la rotta <code>"/stats/maxrate"</code>
	 * che utilizza una chiamata di tipo <code>POST</code>.
	 * Restituisce una statistica effettuta su un dataset con paesi selezionati dall'utente.
	 * 
	 * @param body :  paesi inseriti dall'utente.
	 * @return oggetto <code>MortalityRateModel</code> analizzato.
	 * @throws BodyException 
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 * @see {@link com.esame.progetto.util.stats.StatsMortalityRate#mortalityRate(ArrayList, ArrayList)}
	 */
	@RequestMapping(value="/stats/maxrate", method= RequestMethod.POST)
	public  MortalityRateModel  statsMortalityRate(@RequestBody  String body) throws BodyException, JsonMappingException, JsonProcessingException
	{
		//parsing body inserito dall'utente
		 ObjectMapper obj= new ObjectMapper();
		 CountriesBody countries = null;
		try {
			countries = obj.readValue(body, CountriesBody.class);
		} catch (JsonMappingException e) {
			 throw new BodyException("Body sbagliato o incompleto");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 CountriesBody countriesBody= new CountriesBody(countries.getCountriesList());
		 StatsMortalityRate stat= new StatsMortalityRate();
		return  stat.mortalityRate(summaryService.getSummaryData(), countriesBody.getCountriesList());
	}
	/**
	 * Questo metodo gestisce la rotta <code>"/stats/rate"</code>
	 * che utilizza una chiamata di tipo <code>POST</code>.
	 * Restituisce una statistica effettuata su un dataset con paesi inseriti dall'utente.
	 * @param countries : lista di paesi inseriti dall'utente.
	 * @return ArrayList di oggetti analizzati
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @see {@link com.esame.progetto.util.stats.StatsMortalityRateConf#getRatePerc(ArrayList, ArrayList)}
	 */
	@RequestMapping(value="/stats/rate" , method=RequestMethod.POST)
	public ArrayList<MortRateConfModel>	statsRate(@RequestBody String countries) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper= new ObjectMapper();
	
		CountriesBody cBody = mapper.readValue(countries, CountriesBody.class) ;
		StatsMortalityRateConf stats= new StatsMortalityRateConf();
		 return stats.getRatePerc(summaryService.getSummaryData(),cBody.getCountriesList());
		
		
	
	}
		
		
	
	
	

}
