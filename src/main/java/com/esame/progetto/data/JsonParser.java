package com.esame.progetto.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.esame.progetto.model.InfoCountry;
import com.esame.progetto.model.InfoDayOne;
import com.esame.progetto.model.ResponseDayOne;
import com.esame.progetto.model.ResponseSummary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * La classe <code>JsonParser</code> viene utilizzata
 * per la deserializzazione dei dati in formato <code>JSON</code>.
 * Viene utilizzata principalmente nel package {@link com.esame.progetto.util.service}
 * nei metodi {@link com.esame.progetto.util.service.SummaryServiceImpl#getSummaryData()} e 
 * {@link com.esame.progetto.util.service.DayOneServiceImpl#getDayOneData(String)}
 * per il parsing dei dati ottenuti dalle rotte della classe {@link com.esame.progetto.controller.Controller}.
 * 
 * 
 * @author Alex Dediu
 * @see	{@link com.esame.progetto.model.InfoCountry}
 * @see {@link com.esame.progetto.model.InfoDayOne}
 * 
 */


public class JsonParser {
	/**
	 * Metodo che converte le stringhe <code>JSON</code>,
	 * ottenute dalla connesione ad un <code>URL</code>,
	 * in oggetti di tipo <code>InfoCountry</code>.
	 * 
	 * @param url  utilizzato per ottenere i dati di tipo <code>JSON</code>.
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	public ArrayList<InfoCountry> dataParserSummary(String url) throws JsonMappingException, JsonProcessingException
	{
			
		
			URLConnection urlConnection = null;
			InputStream input= null;
			JsonNode node=null;
			try {
				urlConnection = new URL(url).openConnection();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				 input=urlConnection.getInputStream();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			InputStreamReader inR= new InputStreamReader(input);
			BufferedReader buffer= new BufferedReader(inR);
			
			String line="";
			String data="";
			try {
				while( ( line= buffer.readLine()) != null)
				{
					data+=line;
				}
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			ObjectMapper obj= new ObjectMapper();
			 
			
			ResponseSummary response = obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false).readValue(data,ResponseSummary.class );
			 {
				
			
			}
			System.out.println(response);
			ResponseSummary r = new ResponseSummary(response.getCountries());
			return r.getCountries();	
			
	

}
	/**
	 * Metodo utilizzato per il parsing dei dati  da formato <code>JSON</code>
	 * a oggetto di tipo <code>ResponseDayOneAllStatus</code>.
	 * 
	 * 
	 * @param url utilizzato per ottenere i dati di tipo <code>JSON</code>
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public List<InfoDayOne> dataParserDayOne(String url) throws MalformedURLException, IOException
	{
		ArrayList<InfoDayOne> array= new ArrayList<InfoDayOne>();
		
		
		
		URLConnection 	urlConnection = new URL(url).openConnection();
		
		
		InputStream	 input=urlConnection.getInputStream();
		
		InputStreamReader inR= new InputStreamReader(input);
		BufferedReader buffer= new BufferedReader(inR);
		
		String line="";
		String data="";
		try {
			while( ( line= buffer.readLine()) != null)
			{
				data+=line;
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		ObjectMapper obj= new ObjectMapper();
		List<InfoDayOne> response=   obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false).readValue(data, new TypeReference<List<InfoDayOne>>(){});
		System.out.println(response);
		
		ResponseDayOne r= new ResponseDayOne(response);
		return r.getResponse();
		
		
		
	}
	
}
