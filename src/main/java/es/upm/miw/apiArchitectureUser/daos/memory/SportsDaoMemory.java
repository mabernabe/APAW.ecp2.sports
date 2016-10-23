package es.upm.miw.apiArchitectureUser.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.SportDao;
import es.upm.miw.apiArchitectureUser.entities.Sports;

public class SportsDaoMemory extends GenericMemoryDao<Sports> implements SportDao {

	public SportsDaoMemory() {
		this.setMap(new HashMap<Integer,Sports>());
	}

	@Override
	protected Integer getId(Sports entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sports entity, Integer id) {
		entity.setId(id);
	}


	@Override
	public boolean findSportNameExist(String sportname) {
		List<Sports> sports = this.findAll();
		boolean found = false;
		for (Sports sport : sports) {
			if (sport.getName().equals(sportname))
				found = true;
		}
		return found;
	}

}