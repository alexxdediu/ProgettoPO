package com.esame.progetto.exceptions;
/**
 * Classe che stampa un messaggio di errore in caso di body
 * inserito in modo sbagliato o incompleto
 * @author  Alexandru Dediu
 *
 */
public class BodyException extends Exception {

	public BodyException(String message) {
		super(message);
		
	}
	

}
