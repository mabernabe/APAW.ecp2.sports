package es.upm.miw.apiArchitectureUser.wrappers;

public class UserNickWrapper {
	private String name;

	public UserNickWrapper() {
	}

	public UserNickWrapper(String name) {
		this.setName(name);
	}


	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\"}";
	}

}
