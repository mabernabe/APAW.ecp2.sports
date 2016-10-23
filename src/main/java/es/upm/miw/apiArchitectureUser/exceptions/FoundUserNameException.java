package es.upm.miw.apiArchitectureUser.exceptions;

public class FoundUserNameException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Nombre del usuario ya existe";

	public FoundUserNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public FoundUserNameException() {
		this("");
	}

}



