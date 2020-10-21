package com.esame.progetto.util.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.esame.progetto.model.InfoCountry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
/**
 * Interfaccia utilizzata per restituire i dati della rotta <code>"/data/summary"</code>.
 * 
 * @author  Alexandru Dediu
 * @see {@link com.esame.progetto.controller}
 * @see {@link com.esame.progetto.model.InfoCountry}
 */
@Service
public interface SummaryService {
	public ArrayList<InfoCountry> getSummaryData() throws JsonMappingException, JsonProcessingException;

}
