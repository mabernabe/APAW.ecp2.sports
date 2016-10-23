package es.upm.miw.apiArchitectureUser.api;

import es.upm.miw.apiArchitectureUser.controllers.SportController;
import es.upm.miw.apiArchitectureUser.controllers.UserController;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureUser.exceptions.NotFoundSportNameException;
import es.upm.miw.apiArchitectureUser.exceptions.NotFoundUserNameException;
import es.upm.miw.apiArchitectureUser.exceptions.FoundUserNameException;
import es.upm.miw.apiArchitectureUser.wrappers.UserListWrapper;

public class UserResource {

	// GET **/users
	public UserListWrapper userList() {
		return new UserController().UserList();
	}

	// POST **/users   body="userName"
	public void createUser(String userName, String userEmail) throws InvalidUserFieldException, FoundUserNameException {
		this.validateField(userName);
		this.checkUsernameExist(userName);
		new UserController().createUser(userName, userEmail);
	}

	private void validateField(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException(field);
		}
	}
	
	private void checkUsernameExist(String field) throws FoundUserNameException {
		if (new UserController().checkUserNameExist(field) == true) {
			throw new FoundUserNameException(field);
		}
		
	}
	
	private void checkSportNameNotExist(String field) throws NotFoundSportNameException {
		if (new SportController().checkSportNameExist(field) == false) {
			throw new NotFoundSportNameException(field);
		}
		
	}
	
	private void checkUsernameNotExist(String field) throws NotFoundUserNameException {
		if (new UserController().checkUserNameExist(field) == false) {
			throw new NotFoundUserNameException(field);
		}
		
	}
	
	// POST **/users   body="userName"
	public void addUserSport(String userName, String sportName) throws InvalidUserFieldException, NotFoundUserNameException, NotFoundSportNameException {
		this.validateField(userName);
		this.checkUsernameNotExist(userName);
		this.checkSportNameNotExist(sportName);
		new UserController().addSport(userName, sportName);
	}

	public Object userSportList(String sportname) {
		return new UserController().UserSportList(sportname);
	}


}
