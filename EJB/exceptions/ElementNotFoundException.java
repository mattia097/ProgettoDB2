package it.polimi.db2.progettodb2.exceptions;

public class ElementNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ElementNotFoundException(String message) {
		super(message);
	}
}
