package com.esame.progetto.model;

import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
/**
 * La classe <code>RespondeSummary</code> viene utilizzata per
 * la conversione dei dati <code>JSON</code>.
 * Contiene un <code>ArrayList</code> di oggetti <code>InfoCountry</code>.
 * Vengono utilizzate le annotazioni della libreria<code>JACKSON</code> 
 * per il parsing dei dati.
 * 
 * 
 * @author  Alexandru Dediu
 * @see  {@link com.fasterxml.jackson.annotation}
 * @see  {@link  com.esame.progetto.model.InfoCountry}
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseSummary {
	@JsonProperty(value="Countries")
	/**
	 * <code>ArrayList</code> che contiene tutti gli oggetti  <code>InfoCountry</code>
	 * ottenuti dal parsing dei dati<code>JSON</code>.
	 */
	private ArrayList<InfoCountry> responseCountries;

	@JsonCreator
	public ResponseSummary(@JsonProperty(value="Countries") ArrayList<InfoCountry> response) {
		
		this.responseCountries=response;	
		
	}
	@JsonSetter(value="Countries")
	public ArrayList<InfoCountry> setCountries(@JsonProperty(value= "Countries")ArrayList<InfoCountry> countries) {
		this.responseCountries = countries;
		return this.responseCountries;
	}
	@JsonGetter(value="Countries")
	public ArrayList<InfoCountry> getCountries() {
		return this.responseCountries;
		
	}


}
