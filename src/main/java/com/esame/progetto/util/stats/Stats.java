package com.esame.progetto.util.stats;

import java.util.ArrayList;
/**
 * Classe necessaria per implementare il metodo che effettua la statistica
 * contenuto nella classe <code>StatsDailyIncrease</code>.
 * 
 * @author Alexandru Dediu
 * @see com.esame.progetto.util.stats.StatsDailyIncrease
 * @see com.esame.progetto.controller
 *
 */
public class Stats {
	private Object dailyIncrease;
	private ArrayList<String > dates;
	
	/**
	 * Assegna il tasso di incremento nel range di date contenuto nell' <code>ArrayList</code>.
	 * 
	 * @param dailyIncrease Oggetto che rappresenta il tasso di incremento.
	 */
	public void setDailyIncrease(Object dailyIncrease) {
		this.dailyIncrease = dailyIncrease;
	}
	
	/**
	 * Assegna la data iniziale e la data finale all' <code>ArrayList</code> dates.
	 * @param datesList <code>ArrayList</code> che contiene le date necessarie per effettuare le statistiche.
	 */
	public void setDates(ArrayList<String> datesList) {
		this.dates= datesList;
		
		
	}
	


}
