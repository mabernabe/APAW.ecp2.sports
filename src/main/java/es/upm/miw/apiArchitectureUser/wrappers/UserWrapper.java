package es.upm.miw.apiArchitectureUser.wrappers;

public class UserWrapper {
	private int id;
	private String name;
	private String email;

	public UserWrapper() {
	}

	public UserWrapper(int id, String name, String email) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"name\":\"" + name + ",\"email\":\"" + email + "\"}";
	}

}
