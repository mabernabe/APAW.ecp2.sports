package es.upm.miw.apiArchitectureUser.exceptions;

public class NotFoundSportNameException extends Exception{
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Nombre del deporte no existe";

	public NotFoundSportNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundSportNameException() {
		this("");
	}

}