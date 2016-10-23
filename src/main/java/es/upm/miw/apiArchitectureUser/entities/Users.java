package es.upm.miw.apiArchitectureUser.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Users {

    private int id;

    private String name;
    
    private String email;
    
    private Calendar date;
    
    private List<Sports> sports = new ArrayList<Sports>();

    public Users() {
    }

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
        this.date = Calendar.getInstance();
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

	public Calendar getDate() {
		return date;
	}
	
	public List<Sports> getSports() {
		return sports;
	}
	
	public void addSport(Sports sport) {
		sports.add(sport);
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ",date=" + date + "]";
	}

	public void addSport(String sportname) {
		// TODO Auto-generated method stub
		
	}

}
