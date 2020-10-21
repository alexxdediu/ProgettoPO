package com.esame.progetto.exceptions;
/**
 * Classe che stampa un messaggio di errore in caso di body
 * inserito in modo sbagliato o incompleto
 * @author  Alexandru Dediu
 *
 */
public class BodyException extends Exception {

	private static final long serialVersionUID = 1L;

	public BodyException(String message) {
		super(message);
		
	}
	

}
