package es.upm.miw.apiArchitectureUser.exceptions;

public class FoundSportNameException extends Exception{
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Nombre del deporte ya existe";

	public FoundSportNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public FoundSportNameException() {
		this("");
	}

}
