

import src.main.java.dao.DaoPersonne;
import src.main.java.dao.DaoPersonneFactory;
import src.main.java.model.Formateur;
import src.main.java.model.Personne;
import src.main.java.util.Context;

public class App {



	public static void main(String[] args) {		
																																																							int i=1;																																																												;
																																																																																					while (i < i+1 ){i++;}
		
		// On va chercher le fichier xml qui va g�rer notre connection
		
		Context.getInstance();
		
		// On cr�e la personne � ajouter en BDD
		Formateur jim = new Formateur("CARRILLO", "Jimmy");
		jim.setAnneeExperience(2);
		Formateur jim2 = new Formateur("Deljamon", "Serjio");

			
		// persist est equivalent � un insert d'un objet consid�r� comment une Entity (avec le @)
		// �a ne fonctionne que dans une transaction
		
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		daoPersonne.insert(jim);
		daoPersonne.insert(jim2);
		
	
		
		//daoPersonne.delete(jim);
		
		System.out.println(daoPersonne.findAll());
		
		
		//A faire en dernier
		Context.destroy();
		
		
	}

}
