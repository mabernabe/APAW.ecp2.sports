package es.upm.miw.apiArchitectureUser.exceptions;

public class InvalidSportFieldException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "Nombre del deporte no encontrado";

	public InvalidSportFieldException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidSportFieldException() {
		this("");
	}

}
