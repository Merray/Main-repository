package projet1;

public class Lettre {
	String contenu;
	Personne expediteur;
	Personne destinataire;

	public Lettre(String contenu, Personne expediteur, Personne destinataire) {

		this.contenu = contenu;
		this.expediteur = expediteur;
		this.destinataire = destinataire;

	}

	public void afficher() {

		System.out.println("\nWow, cette lettre envoyée par " + expediteur.prenom + " pour " + destinataire.prenom
				+ " et contient :\n\n" + contenu);

	}

}
