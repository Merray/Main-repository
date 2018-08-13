

import java.util.List;

import src.main.java.dao.DaoAdherent;
import src.main.java.dao.DaoAdherentFactory;
import src.main.java.model.Adherent;
import src.main.java.model.Adresse;
import src.main.java.util.Context;

public class App {

	public static void main(String[] args) {
		

		// On va chercher le fichier xml qui va gérer notre connection

		Context.getInstance();


		Adresse ad = new Adresse("e", 77310, "Ponthierry");
		Adresse ad2 = new Adresse("ef", 77310, "Comb la ville");
		Adherent jim = new Adherent();
		Adherent marine = new Adherent();
		jim.setPrenom("Jimmy");
		jim.setAdresse(ad);
		marine.setAdresse(ad2);
		marine.setPrenom("Marine");
		
		
		DaoAdherent daoAdherent = DaoAdherentFactory.getInstance();
		
		daoAdherent.insert(jim);
		daoAdherent.insert(marine);
		
		List<Adherent> liste = daoAdherent.findByCity(ad.getVille());
		
		System.out.println(liste);
		// persist est equivalent à un insert d'un objet considéré comment une Entity
		// (avec le @)
		// ça ne fonctionne que dans une transaction

		// A faire en dernier
		Context.destroy();

	}

}
