package com.esame.progetto.util.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.esame.progetto.data.JsonParser;
import com.esame.progetto.exceptions.ServiceException;
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
public class DayOneServiceImpl implements DayOneService{

	@Override
	public List<InfoDayOne> getDayOneData(String country) throws ServiceException    {
		JsonParser parser= new JsonParser();
		 try {
			return parser.dataParserDayOne( "https://api.covid19api.com/dayone/country/"+ country);
		} catch (IOException e) {
			throw new ServiceException("problema di Input");
		}
	}
	
}
