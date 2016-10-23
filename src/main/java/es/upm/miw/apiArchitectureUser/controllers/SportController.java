package es.upm.miw.apiArchitectureUser.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.entities.Sports;
import es.upm.miw.apiArchitectureUser.wrappers.SportListWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.SportWrapper;

public class SportController {

	public boolean createSport( String sport) {
		if (sport != null) {
			DaoFactory.getFactory().getSportDao().create(new Sports(sport));
			return true;
		} else {
			return false;
		}
	}

	public SportListWrapper sportList() {
		List<Sports> sports = DaoFactory.getFactory().getSportDao().findAll();
		SportListWrapper sportListWrapper = new SportListWrapper();
		for (Sports sport : sports) {
			sportListWrapper.addSportWrapper(new SportWrapper(sport.getName()));
		}
		return sportListWrapper;
	}
	
	public boolean checkSportNameExist(String sportName) {
		return DaoFactory.getFactory().getSportDao().findSportNameExist(sportName);
	}


}
