package com.esame.progetto.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
/**
 * Classe utilizzata per il parsing del parametro body inserito dall utente nel formato <code>JSON</code>
 * nel  metodo {@link com.esame.progetto.controller.Controller#statsMortalityRate(String)}.
 * 
 * @author Alexandru Dediu
 * 
 *
 */
public class CountriesBody {
	/**
	 *  Vengono utilizzate le  annotazioni della  libreria <code>JACKSON</code>
	 *  per il parsing dei dati.
	 */
	@JsonProperty(value="countries")
	private ArrayList<String> countriesList;

	public CountriesBody(@JsonProperty(value="countries")ArrayList<String> name) {
		super();
		this.countriesList = name;
	}
	@JsonGetter(value="countries")
	public ArrayList<String> getCountriesList() {
		return countriesList;
	}
	@JsonSetter(value="countries")
	public void setCountriesList(ArrayList<String> countriesName) {
		this.countriesList = countriesName;
	}
	
	
	

}
