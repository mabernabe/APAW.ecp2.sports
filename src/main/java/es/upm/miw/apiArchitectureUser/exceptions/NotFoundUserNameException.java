package es.upm.miw.apiArchitectureUser.exceptions;

public class NotFoundUserNameException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Nombre del usuario no existe";

	public NotFoundUserNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundUserNameException() {
		this("");
	}

}

