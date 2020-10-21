package com.esame.progetto.util.stats;


import java.util.ArrayList;
import java.util.List;

import com.esame.progetto.model.DailyIncreaseModel;
import com.esame.progetto.model.InfoDayOne;
/**
 * Classe utilizzata per efettuare una statistica sull'incremento giornaliero del tasso di mortlità.
 * Vengono analizzati i dati ottenuti dalla rotta  <code>"/data/dayone"</code> della classe
 * {@link com.esame.progetto.controller.Controller}.
 * 
 * 
 * @author  Alexandru Dediu
 * @see {@link com.esame.progetto.util.stats.Stats}
 *
 */

public class StatsDailyIncrease extends Stats {
	/**
	 * Metodo che converte una Stringa in oggetto di tipo Double.
	 * utilizzato per  il numero dei decessi.
	 * @param s : Stringa da convertire.
	 */
	@Override
	 public Object convertString(String s) {
		  Double d= Double.parseDouble(s);
		return d;
	}
/**
 * Metodo che riporta un <code>ArrayList</code> nel quale ad ogni oggetto di tipo <code>Stats</code>
 * vengono assegnati  i valori del tasso di incremento percentuale  e il range delle date.
 * 
 * @param response :  Dati ottenuti dalla rotta <code>"/data/dayone"</code>.
 * @return <code>ArrayList</code> con valori assegnati per ogni oggetto <code>Stats</code>.
 * @see  {@link com.esame.progetto.model.DailyIncreaseModel}
 * @see  {@link com.esame.progetto.controller.Controller#statsDailyIncreaseRequest(String)}
 */

	public ArrayList<DailyIncreaseModel> dailyIncrease(List<InfoDayOne> response) {
		
		ArrayList<DailyIncreaseModel> statsList = new ArrayList<DailyIncreaseModel>();

		for (int i = 0; i <= response.size() - 2; i++) {

			for (int j = i + 1; j <= response.size() - 1; j++) {
				
				ArrayList<String> dates = new ArrayList<String>();
				DailyIncreaseModel s = new DailyIncreaseModel();
				// aggiunte data di inizio e data finale 
				dates.add(response.get(i).getDate());
				dates.add(response.get(j).getDate());
				
				s.setDates(dates);
				statsList.add(s);
				// vengono assegnati i valori da analizzare ottenuti dalla risposta
				Double a = (Double) convertString(response.get(i).getnDeaths());
				Double b = (Double)  convertString(response.get(j).getnDeaths());
				
				// possibili casi per il calcolo del tasso di incremento percentuale
				if (b > a) {
					if (a == 0) {
						//nessun incremento se nel  giorno precedente il numero di decessi corrisponde a 0
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

				
				
			
		
	
		
		
		
		
		
		
		
		
		
		
	

	
	

	


