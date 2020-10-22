package com.esame.progetto.util.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.esame.progetto.data.JsonParser;
import com.esame.progetto.model.InfoCountry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
/**
 * Classe utilizzata per restituire un <code>ArrayList</code> di oggetti <code>InfoCountry</code>.
 * 
 * @author Alexandru Dediu
 * @see {@link com.esame.progetto.model.InfoCountry}
 * @see {@link com.esame.progetto.data.JsonParser}
 *
 */
@Service
public class SummaryServiceImpl implements SummaryService {

	@Override
	public ArrayList<InfoCountry> getSummaryData() throws JsonMappingException, JsonProcessingException {
		JsonParser p= new JsonParser();
		return p.dataParserSummary("https://api.covid19api.com/summary");
		
	}
	

}
