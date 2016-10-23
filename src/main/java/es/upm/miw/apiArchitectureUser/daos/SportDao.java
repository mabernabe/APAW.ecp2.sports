package es.upm.miw.apiArchitectureUser.daos;


import es.upm.miw.apiArchitectureUser.entities.Sports;

public interface SportDao extends GenericDao<Sports, Integer> {
	boolean findSportNameExist(String sportname);
}
