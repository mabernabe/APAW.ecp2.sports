package es.upm.miw.apiArchitectureUser.entities;

public class Sports {

    private int id;

    private String name;

    public Sports() {
    }

    public Sports(String name) {
        this.name = name;
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

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}

}
