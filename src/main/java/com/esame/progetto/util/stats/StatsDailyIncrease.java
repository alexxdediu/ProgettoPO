package com.esame.progetto.util.stats;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.esame.progetto.model.InfoDayOne;
/**
 * Classe utilizzata per efettuare una statistica sull'incremento giornaliero del tasso di mortlità.
 * Vengono analizzati i dati ottenuti dalla rotta  <code>"/data/dayone"</code> del controller.
 * 
 * @author  Alexandru Dediu
 * @see com.esame.progetto.util.stats.Stats
 *
 */

public class StatsDailyIncrease {
	

/**
 * Metodo che riporta un <code>ArrayList</code> nel quale in ogni  oggetto di tipo <code>Stats</code>
 * vengono assegnati  i valori del tasso di incremento percentuale  e il range delle date.
 * 
 * @param response Risposta ottenuta dalla rotta <code>"/data/dayone"</code>,che contiene i dati da analizzare
 * @return <code>ArrayLisy</code> con valori assegnati per ogni oggetto <code>Stats</code>.
 * @see  com.esame.progetto.controller
 */

	public ArrayList<Stats> dailyIncrease(List<InfoDayOne> response) {

		ArrayList<Stats> statsList = new ArrayList<Stats>();

		for (int i = 0; i <= response.size() - 2; i++) {

			for (int j = i + 1; j <= response.size() - 1; j++) {
				
				ArrayList<String> dates = new ArrayList<String>();
				Stats s = new Stats();
				// aggiunte data di inizio e data finale 
				dates.add(response.get(i).getDate());
				dates.add(response.get(j).getDate());
				
				s.setDates(dates);
				statsList.add(s);
				// vengono assegnati i valori da analizzare ottenuti dalla risposta
				Double a = response.get(i).stringInDouble(response.get(i).getnDeaths());
				Double b = response.get(j).stringInDouble(response.get(j).getnDeaths());
				
				// possibili casi per il calcolo del tasso di incremento percentuale
				if (b > a) {
					if (a == 0) {
						//nessun incremento se il giorno precedente il numero di decessi corrispondeva a 0
						s.setDailyIncrease("Nessun Incremento");
						break;
					} else if (a > 0) {
						//cacolo del tasso di incremento percentuale
						Double res = ((b - a) / a) * 100;
						s.setDailyIncrease(res);
						

						break;
					}
				} else if (a > b) {
					if (b == 0) {

						s.setDailyIncrease("Nessun Incremento");
						
						break;
					} else if (b > 0) {
						
						Double res = ((b - a) / a) * 100;
						s.setDailyIncrease(res);
					

						break;
					}
				} else if (b == a || (b == 0 && a == 0)) {
					
					s.setDailyIncrease("Nessun Incremento");

					break;
				}
				//oggetto Stats  aggiunto all'ArrayList
				statsList.add(s);

			}

		}

		return statsList;

	}

}

				
				
			
		
	
		
		
		
		
		
		
		
		
		
		
	

	
	

	


