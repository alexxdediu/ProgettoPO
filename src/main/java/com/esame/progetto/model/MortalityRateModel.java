package com.esame.progetto.model;

import java.util.ArrayList;


public class MortalityRateModel{
	
	private ArrayList<String> compareCountries;
	
	private String countryName;
	private Integer maxRate;
	

	public ArrayList<String> getCompareCountries() {
		return compareCountries;
	}

	public void setCompareCountries(ArrayList<String> compareCountriesNames) {
		this.compareCountries = compareCountriesNames;
	}

	public String getCountryName() {
		return countryName;
	}

	public Integer getMaxRate() {
		return maxRate;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setMaxRate(Integer maxRate) {
		this.maxRate = maxRate;
	}

	
	
}
