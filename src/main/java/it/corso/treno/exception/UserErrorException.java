package it.corso.treno.exception;

public class UserErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	public UserErrorException() {
			super("Anomalia in esecuzione");
	}
	public UserErrorException(String messaggio) {
		super("Anomalia in esecuzione: " + messaggio);
	}
	public String toString() {
		return getMessage();
	}
	
}