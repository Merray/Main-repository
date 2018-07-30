package annuaire;


import java.io.Serializable;
import java.util.HashMap;

public class Annuaire implements Serializable{

	HashMap<String, Coordonnees> maCollection;

	public Annuaire(HashMap<String, Coordonnees> maCollection) {
		this.maCollection = maCollection;
	}

	public void ajout(String nom, Coordonnees coord) {

		maCollection.put(nom, coord);

	}

	public void affichCoord(String nom) {

		System.out.println("Coordonnées de " + nom + ": " + maCollection.get(nom));

	}

	public void modifCoord(String nom, Coordonnees coord) {

		maCollection.remove(nom);
		maCollection.put(nom, coord);

	}

	public void suppression(String nom) {

		maCollection.remove(nom);
		System.out.println("\nLe contact du nom de " + nom + " a été supprimé");

	}

	public void listerNoms() {

		System.out.println("\nTous les noms de mon annuaire : " + maCollection.keySet());

	}

	public void listerTel() {

		System.out.println("\nTous les numéros de tel de mon annuaire :");

		for (Coordonnees coord : maCollection.values()) {

			System.out.println(coord.getTel());
		}
	}

	public void listerAdr() {

		System.out.println("\nToutes les adresses de mon annuaire :");

		for (Coordonnees coord : maCollection.values()) {

			System.out.println(coord.getAdresse());
		}

	}
	
	public void affichAnnuaire() {
		
		System.out.println("\nMon annuaire complet :\n");
		
		System.out.println(maCollection);
		
		
	}
	

}
