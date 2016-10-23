package es.upm.miw.apiArchitectureUser.wrappers;

public class SportWrapper {
	private String sportName;

	public SportWrapper() {
	}

	public SportWrapper( String sportName) {
		this.sportName = sportName;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	@Override
	public String toString() {
		return "{\"SportName\":" + sportName + "}";
	}

}
