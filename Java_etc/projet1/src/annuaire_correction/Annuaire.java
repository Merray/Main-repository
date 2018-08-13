package annuaire_correction;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Annuaire implements Serializable{
	private Map<String, Set<Coordonnee>> annuaire = new HashMap<>();

	public Annuaire() {

	}

	public void ajout(String nom, Coordonnee coordonnee) {
		if (annuaire.containsKey(nom)) {
			annuaire.get(nom).add(coordonnee);
		} else {
			Set<Coordonnee> set = new HashSet<>();
			set.add(coordonnee);
			annuaire.put(nom, set);
		}
	}

	public void afficherCoordonnees(String nom) {
		System.out.println(annuaire.get(nom));
	}

	public void modifierCoordonnees(String nom, Coordonnee coordonnee) {
		Set<Coordonnee> coordonnees = annuaire.get(nom);
		coordonnees.remove(coordonnee);
		coordonnees.add(coordonnee);
	}

	public void supprimerCoordonnees(String nom, Coordonnee coordonnee) {
		if (annuaire.get(nom) != null)
			annuaire.get(nom).remove(coordonnee);
	}

	public void supprimer(String nom) {
		if (annuaire.get(nom) != null)
			annuaire.remove(nom);
	}

	public void listeNoms() {
		System.out.println(annuaire.keySet());
	}

	public void listeTelephone() {
		Collection<Set<Coordonnee>> coordonnees = annuaire.values();
		for (Set<Coordonnee> c : coordonnees) {
			for (Coordonnee coord : c) {
				System.out.println(coord.getTelephone());
			}
		}
	}

	public void listeAdresse() {
		Collection<Set<Coordonnee>> coordonnees = annuaire.values();
		for (Set<Coordonnee> c : coordonnees) {
			for (Coordonnee coord : c) {
				System.out.println(coord.getAdresse());
			}
		}
	}

	public void afficher() {
		System.out.println(annuaire);
	}
}
