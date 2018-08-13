package src.main.java.dao;


import java.util.List;

import src.main.java.model.Salle;

public interface DaoSalle extends DaoGeneric<Salle, Integer>{
	
	List<Salle> findAllWithPersonne();

	
	
}
