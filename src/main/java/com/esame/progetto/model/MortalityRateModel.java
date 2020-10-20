package com.esame.progetto.model;

import java.util.ArrayList;


public class MortalityRateModel{
	
	private ArrayList<String> compareCountriesNames;
	
	private String countryName;
	private Integer maxRate;
	

	public ArrayList<String> getCompareCountriesNames() {
		return compareCountriesNames;
	}

	public void setCompareCountriesNames(ArrayList<String> compareCountriesNames) {
		this.compareCountriesNames = compareCountriesNames;
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
