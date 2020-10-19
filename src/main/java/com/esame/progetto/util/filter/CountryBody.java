package com.esame.progetto.util.filter;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CountryBody {
	@JsonProperty(value= "country")
	private String countryName;

	public CountryBody(@JsonProperty(value="country") String name)
	{
		this.countryName=name;
	
	}
	@JsonGetter(value="country")
	public String getCountryName() {
		return countryName;
	}
	@JsonSetter(value="country")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
