package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{

	List<Personne>findByPrenom(String prenom);
	List<Personne>findByPrenomContaining(String prenom);
	List<Personne>findByPrenomEndingWith(String prenom);
	
}
