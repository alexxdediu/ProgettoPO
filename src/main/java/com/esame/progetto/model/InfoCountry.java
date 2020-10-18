package com.esame.progetto.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
/**
 *La classe <code>InfoCountry</code> viene utilizzata
 *per la conversione dei dati <code>JSON</code>.
 *Contiene tutte le informazioni utili ottenute dal parsing dei dati.
 *
 * @author  Alex Dediu 
 * @see  com.esame.progetto.model.ResponseSummary
 * @see com.fasterxml.jackson.annotation
 */

/**
 * 
 * Annotazione della libreria <code>JACKSON</code> utilizzata per
 *  ignorare tutti i campi del <code>JSON</code> non necessari.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)


public class InfoCountry {
	/**
	 * Vengono utilizzate le annotazioni della libreria <code>JACKSON</code>
	 * per il parsing dei dati.
	 */
	@JsonProperty(value="Country")
	private String countryName;
    @JsonProperty(value="TotalConfirmed")
	private String totConfirmed;
	@JsonProperty(value="TotalDeaths")
	private String totDeaths;
	@JsonProperty(value="TotalRecovered")
	private String totRecovered;
	
	/**
	 * Costruttore della classe <code>InfoCountry</code> utilizzato per inizializzare
	 * le variabili di istanza  con i dati ottenuti dal parsing del <code>JSON</code>.
	 * 
	 * @param name nome del paese
	 * @param totC totale dei casi confermati
	 * @param totR totale dei guariti
	 * @param totD totale dei casi di decesso.
	 */
	public InfoCountry(@JsonProperty(value="Country") String name,@JsonProperty(value="TotalConfirmed") String totC,@JsonProperty(value="TotalRecovered") String totR,@JsonProperty(value="TotalDeaths") String totD)
	{
		
		this.countryName = name;
		this.totConfirmed =totC;
		this.totDeaths = totD;
		this.totRecovered = totR;
	}
	@JsonGetter(value="Country")
	public String getCountryName() {
		return countryName;
	}
	@JsonSetter(value="Country")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@JsonGetter(value="TotalConfirmed")
	public String getTotConfirmed() {
		return totConfirmed;
	}
	@JsonSetter(value="TotalConfirmed")
	public void setTotConfirmed(String totConfirmed) {
		this.totConfirmed = totConfirmed;
	}
	@JsonGetter(value="TotalDeaths")
	public String getTotDeaths() {
		return totDeaths;
	}
	@JsonSetter(value="TotalDeaths")
	public void setTotDeaths(String totDeaths) {
		this.totDeaths = totDeaths;
	}
	@JsonGetter(value="TotalRecovered")
	public String getTotRecovered() {
		return totRecovered;
	}
	@JsonSetter(value="TotalRecovered")
	public void setTotRecovered(String totRecovered) {
		this.totRecovered = totRecovered;
	}
	
	

}
