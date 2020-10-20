package com.esame.progetto.exceptions;
/**
 * Eccezione personalizzata utilizzata per le classi <code>Service</code>  in caso di dati non restituiti correttamente.
 * @author Alexandru Dediu
 *
 */
public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ServiceException (String message)
	{
		super(message);
	}

}
