package com.esame.progetto.util.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.esame.progetto.data.JsonParser;
import com.esame.progetto.model.InfoDayOne;
/**
 * Classe utilizzata per restituire una <code>List</code> di oggetti di tipo<code>InfoDayOne</code>.
 * 
 * @author Alexandru Dediu
 * @see {@link com.esame.progetto.controller}
 * @see {@link com.esame.progetto.model.InfoDayOne}
 *
 */
@Service
public class DayOneServiceImpl implements DayOneService {

	@Override
	public List<InfoDayOne> getDayOneData(String country) throws MalformedURLException, IOException {
		JsonParser parser= new JsonParser();
		 return parser.DataParserDayOne( "https://api.covid19api.com/dayone/country/"+ country);
	}
	
}
