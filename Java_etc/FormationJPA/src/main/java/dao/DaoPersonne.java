package dao;

import java.util.List;

import formationJpa.model.Formateur;
import formationJpa.model.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Integer> {
	List<Formateur> findAllFormateur();
}
