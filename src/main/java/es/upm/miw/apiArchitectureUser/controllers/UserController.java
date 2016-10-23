package es.upm.miw.apiArchitectureUser.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.entities.Sports;
import es.upm.miw.apiArchitectureUser.entities.Users;
import es.upm.miw.apiArchitectureUser.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.UserNickListWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.UserNickWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper UserList() {
		List<Users> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (Users user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getName(), user.getEmail()));
		}
		return userListWrapper;
	}

	public void createUser(String userName, String userEmail) {
		DaoFactory.getFactory().getUserDao().create(new Users(userName, userEmail));
	}
	
	public boolean checkUserNameExist(String userName) {
		return DaoFactory.getFactory().getUserDao().findUserNameExist(userName);
	}
	
	public void addSport(String userName, String sportName) {
		List<Sports> sportList = DaoFactory.getFactory().getSportDao().findAll();
		for (Sports sport: sportList) {
			if (sport.getName().equals(sportName))
				DaoFactory.getFactory().getUserDao().addSport(userName, sport);
		}
	}

	public Object UserSportList(String sportname) {
		List<Users> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserNickListWrapper userListWrapper = new UserNickListWrapper();
		for (Users user : userList) {
			for (Sports sport : user.getSports()) {
				if (sport.getName().equals(sportname))
					userListWrapper.addUserNickWrapper(new UserNickWrapper(user.getName()));
			}
		}
		return userListWrapper;
	}
	
}
