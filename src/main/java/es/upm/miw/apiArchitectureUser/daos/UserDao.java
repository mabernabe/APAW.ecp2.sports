package es.upm.miw.apiArchitectureUser.daos;

import es.upm.miw.apiArchitectureUser.entities.Sports;
import es.upm.miw.apiArchitectureUser.entities.Users;

public interface UserDao extends GenericDao<Users, Integer> {
	boolean findUserNameExist(String username);
	void addSport(String username, Sports sport);
}
