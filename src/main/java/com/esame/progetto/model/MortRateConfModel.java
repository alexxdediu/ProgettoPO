package com.esame.progetto.model;
/**
 * Classe utilizzata per rappresentare gli oggetti inseriti nell' <code>ArrayList</code>
 * riportato dalla rotta <code>"/stats/rate"</code>.
 * 
 * @author Dediu Alexandru
 * @see {@link com.esame.progetto.util.stats.StatsMortalityRateConf}
 *
 */
public class MortRateConfModel {
	private String countryName;
	private Double roundRate;
	
	public String getCountryName() {
		return countryName;
	}
	public Double getRoundRate() {
		return roundRate;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public void setRoundRate(Double rateCompareConfirmed) {
		this.roundRate = rateCompareConfirmed;
	}
	

}
