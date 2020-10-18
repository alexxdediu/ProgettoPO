package com.esame.progetto.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
/**
 * Questa classe viene utilizzata per la conversione dei dati in formato <code>JSON</code>.
 * Contiene un <code>ArrayList</code> di oggetti <code>InfoDayOne</code>.
 * vengono utilizzate le annotazioni della libreria <code>JACKSON</code> per il parsing dei dati.
 *
 * @author Alex Dediu
 * @see com.esame.progetto.model.InfoDayOne
 * @see com.fasterxml.jackson.annotation
 *
 */

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class ResponseDayOne {
	/**
	 * <code>List</code> che contiene tutti gli oggetti <code>InfoDayOne</code>
	 * ottenuti dal parsing dei dati in formato  <code>JSON</code>.
	 */
	@JsonProperty
	private List<InfoDayOne> responseDayOne;

	public ResponseDayOne(@JsonProperty List<InfoDayOne> responseJson) {
		this.responseDayOne = responseJson;
	}
	@JsonGetter
	public List<InfoDayOne> getResponse() {
		return responseDayOne;
	}
	@JsonSetter
	public void setResponse(List<InfoDayOne> response) {
		this.responseDayOne = response;
	}
	
	

}
