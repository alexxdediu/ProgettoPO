package com.esame.progetto.model;

import java.util.ArrayList;
/**
 * Classe utilizzata per rappresentare gli oggetti inseriti nell' <code>ArrayList</code>
 * riportato dalla rotta <code>"/stats/maxrate"</code>.
 * 
 * @author Alexandru Dediu
 * @see {@link com.esame.progetto.util.stats.StatsMortalityRate}
 *
 */

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
