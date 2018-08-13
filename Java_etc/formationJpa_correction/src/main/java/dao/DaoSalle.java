package dao;

import java.util.List;


import formationJpa.model.Salle;

public interface DaoSalle extends DaoGeneric<Salle, Integer> {
	List<Salle> findAllWithPersonne();
}
