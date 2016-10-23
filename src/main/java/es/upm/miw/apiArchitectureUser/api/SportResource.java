package es.upm.miw.apiArchitectureUser.api;

import es.upm.miw.apiArchitectureUser.controllers.SportController;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureUser.exceptions.FoundSportNameException;
import es.upm.miw.apiArchitectureUser.wrappers.SportListWrapper;

public class SportResource {

	// POST **/sports   
	public void createSport(String sportName) throws InvalidSportFieldException, FoundSportNameException {
		this.validateField(sportName);
		this.checkSportnameExist(sportName);
		if (!new SportController().createSport(sportName)) {
		}
	}
	
	private void checkSportnameExist(String field) throws FoundSportNameException {
		if (new SportController().checkSportNameExist(field)) {
			throw new FoundSportNameException(field);
		}
		
	}
	

	// GET **/sports
	public SportListWrapper sportList() {
		return new SportController().sportList();
	}
	
	private void validateField(String field) throws InvalidSportFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidSportFieldException(field);
		}
	}

}
