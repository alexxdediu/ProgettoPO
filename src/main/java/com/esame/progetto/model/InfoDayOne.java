package com.esame.progetto.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"CountryCode","Province","City","CityCode","Lat","Lon","Recovered","Active"})
public class InfoDayOne {
	@JsonProperty(value="Country")
	private String countryName;
	@JsonProperty(value="Deaths")
	private String nDeaths;
	@JsonProperty(value="Confirmed")
	private String nConfirmed;
	@JsonProperty(value="Date")
	private String date;
	
	public InfoDayOne(@JsonProperty(value="Country") String name, @JsonProperty(value="Deaths") String deaths,@JsonProperty(value="Confirmed") String confirmed,@JsonProperty(value="Date") String dateJson) {
		
		this.countryName = name;
		this.nDeaths =deaths;
		this.nConfirmed = confirmed;
		this.date = dateJson;
	}


	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getnDeaths() {
		return nDeaths;
	}

	public void setnDeaths(String nDeaths) {
		this.nDeaths = nDeaths;
	}

	public String getnConfirmed() {
		return nConfirmed;
	}

	public void setnConfirmed(String nConfirmed) {
		this.nConfirmed = nConfirmed;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Calendar dateStringinDateObj(String date)
	{
		String date1= date.substring(0, 10);
		Date d = null;
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
		try {
			 d= dateFormat.parse(date1);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Calendar cal=Calendar.getInstance();
		 cal.setTime(d);
		return cal;
		
		
	}
	

}
