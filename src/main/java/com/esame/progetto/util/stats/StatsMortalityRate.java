package com.esame.progetto.util.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import com.esame.progetto.model.InfoCountry;
import com.esame.progetto.model.MortalityRateModel;
/**
 * Classe utilizzata per efettuare una statistica su un <code>ArrayList</code> di paesi.
 * vengono analizzati i dati ottenuti dalla rotta <code>"data/summary"</code>.
 * 
 * @author Alexandru Dediu
 * @see {@link com.esame.progetto.model.InfoCountry}
 * @see  {@link com.esame.progetto.util.stats.MortalityRateModel}
 * @see  {@link com.esame.progetto.controller}
 * 
 *
 */
public class StatsMortalityRate extends Stats{
	@Override
	public Object convertString( String s)
	{
		Integer i = Integer.parseInt(s);
		return i ;
	}
	/**
	 * Metodo che riporta un oggetto di tipo <code>MortalityRateModel</code>
	 * che contiene i dati analizzati.
	 * @param response : Dati ottenuti dalla rotta <code>"/data/summary"</code>.
	 * @param countries : <code>ArrayList</code> di paesi inseriti dall'utente.
	 * @return Oggetto di tipo <code>MortalityRateModel</code>.
	 * @see {@link com.esame.progetto.model.MortalityRateModel}
	 */

	public MortalityRateModel mortalityRate(ArrayList<InfoCountry> response, ArrayList<String> countries)
	{
		MortalityRateModel model= new MortalityRateModel();
		//ArrayList che contiene il numero dei decessi di ogni paese inserito dall'utente.
		ArrayList<Integer>  values= new ArrayList<Integer>();
		HashMap<String,Integer> map= new HashMap<String,Integer>();
		
		for(InfoCountry i : response)
		{
			for(String s : countries)
			{
				//vengono assegnati  i paesi inseriti dall'utente alla variabile di istanza dell'oggetto.
				model.setCompareCountriesNames(countries);
				
				if(i.getCountryName().equals(s))
				{
					//conversione della stringa corrispondente al numero dei decessi.
					Integer n = (Integer) convertString(i.getTotDeaths());
					map.put(s, n);
					values.add(n);
					
					
				}
			}
		}
		//viene assegnato a maxValue il valore massimo 
		//ottenuto dall'ArrayList con il numero di decessi dei paesi selezionati dall'utente.
		Integer maxValue= Collections.max(values);
		//viene assegnato il valore massimo alla variabile di istanza.
		model.setMaxRate(maxValue);
		for(Entry<String,Integer> entry : map.entrySet())
		{
			//vengono confrontati i valori per ottenere la Key 
			//corrispondente al paese con il maggior numero di decessi.
			if(entry.getValue().equals(maxValue))
			{
				//viene assegnato il paese con il maggior numero di decessi alla variabile di istanza.
				model.setCountryName(entry.getKey());
			}
		}
		
		
		 return model;
	}
}
	

