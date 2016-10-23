package es.upm.miw.apiArchitectureUser.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.UserDao;
import es.upm.miw.apiArchitectureUser.entities.Sports;
import es.upm.miw.apiArchitectureUser.entities.Users;

public class UsersDaoMemory extends GenericMemoryDao<Users> implements UserDao {

	public UsersDaoMemory() {
		this.setMap(new HashMap<Integer, Users>());
	}

	@Override
	protected Integer getId(Users entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Users entity, Integer id) {
		entity.setId(id);

	}

	@Override
	public boolean findUserNameExist(String username) {
		List<Users> users = this.findAll();
		boolean found = false;
		for (Users user : users) {
			if (user.getName().equals(username))
				found = true;
		}
		return found;
	}

	@Override
	public void addSport(String username, Sports sport) {
		List<Users> users = this.findAll();
		for (Users user : users) {
			if (user.getName().equals(username))
				user.addSport(sport);
		}
	}

}