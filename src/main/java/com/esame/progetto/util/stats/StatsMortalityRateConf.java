package com.esame.progetto.util.stats;

import java.util.ArrayList;

import com.esame.progetto.model.InfoCountry;
import com.esame.progetto.model.MortRateConfModel;
/**
 * Classe utilizzata per efettuare una statistica su un <code>ArrayList</code> di paesi.
 * vengono analizzati i dati ottenuti dalla rotta <code>"data/summary"</code>.
 * Riporta la percentuale di decessi rispetto ai casi confermati dei paesi inseriti dall'utente.
 * @author Alexandru Dediu
 * @see {@link com.esame.progetto.model.MortRateConfModel}
 *
 */
public class StatsMortalityRateConf extends Stats {
	

	@Override
	public Object convertString(String s) {
		Double d= Double.parseDouble(s);
		return d;
	}
	/**
	 * 
	 * @param list : Risposta ottenuta dalla rotta <code>"/data/summary"</code>.
	 * @param params : paesi inseriti dall'utente.
	 * @return  <code>ArrayList</code>  di dati analizzati.
	 * @see {@link com.esame.progetto.controller.Controller#statsRate(String)}
	 */
	
	public ArrayList<MortRateConfModel> getRatePerc(ArrayList<InfoCountry> list,ArrayList<String> params)
	{
		ArrayList<MortRateConfModel> listModel= new ArrayList<MortRateConfModel>();
		
		
		for(InfoCountry i : list)
		{
			
			for(String s : params) {
			if(i.getCountryName().equals(s))
			{
				MortRateConfModel m= new MortRateConfModel();
				 Double conf=(Double) convertString(i.getTotConfirmed());
				 Double deaths= (Double) convertString(i.getTotDeaths());
				 Double res = (deaths*100)/conf;
				 res=(double) Math.round(res);
				 m.setCountryName(s);
				 m.setRoundRate(res);
				 listModel.add(m);
				
				
			}
			}
		}
		return listModel;
		
	}


}
