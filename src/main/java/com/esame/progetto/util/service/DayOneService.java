package com.esame.progetto.util.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.stereotype.Service;
import com.esame.progetto.model.InfoDayOne;
/**
 * Interfaccia che contiene un metodo utilizzato per restituire 
 * i dati della rotta <code>"/data/dayone/{country}"</code>.
 * 
 * @author Alexandru Dediu
 * @see {@link com.esame.progetto.controller.Controller}
 * 
 */
@Service
public interface DayOneService {
	public List<InfoDayOne> getDayOneData(String country) throws MalformedURLException, IOException;



}
