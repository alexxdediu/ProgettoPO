package com.esame.progetto.util.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.esame.progetto.model.InfoCountry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
/**
 * 
 * 
 * @author  Alex Dediu
 *
 */
@Service
public interface SummaryService {
	public ArrayList<InfoCountry> getSummaryData() throws JsonMappingException, JsonProcessingException;

}
