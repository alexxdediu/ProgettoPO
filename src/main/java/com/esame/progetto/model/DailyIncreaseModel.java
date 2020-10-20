package com.esame.progetto.model;

import java.util.ArrayList;
/**
 * Classe necessaria per implementare il metodo che effettua la statistica
 * contenuto nella classe <code>StatsDailyIncrease</code>.
 * Utilizzata principalmente nel metodo {@link com.esame.progetto.util.stats.StatsDailyIncrease#dailyIncrease(java.util.List)}.
 * 
 * @author Alexandru Dediu
 * @see {@linkcom.esame.progetto.util.stats.StatsDailyIncrease}
 * @see {@link com.esame.progetto.controller.Controller}
 *
 */
public class DailyIncreaseModel {
	private Object dailyIncrease;
	private ArrayList<String > dates;
	
	
	public Object getDailyIncrease() {
		return dailyIncrease;
	}

	public ArrayList<String> getDates() {
		return dates;
	}
	
	public void setDailyIncrease(Object dailyIncrease) {
		this.dailyIncrease = dailyIncrease;
	}
	
	public void setDates(ArrayList<String> datesList) {
		this.dates= datesList;
		
		
	}
	


}
