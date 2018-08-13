package src.main.java.dao;

import java.util.List;

import src.main.java.model.Formateur;
import src.main.java.model.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Integer>{

	List<Formateur> findAllFormateur();
	
	
}
