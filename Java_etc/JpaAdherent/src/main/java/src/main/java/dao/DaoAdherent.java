package src.main.java.dao;

import java.util.List;

import src.main.java.model.Adherent;

public interface DaoAdherent extends DaoGeneric<Adherent, Integer>{

	List<Adherent> findByCity(String city);
	
}
