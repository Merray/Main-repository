package projet1;

public class Stagiaire extends Personne {

	int anneesEtudes;

	public Stagiaire(String nom, String prenom, String adresse, int anneesEtudes) {
		super(nom, prenom, adresse);
		this.anneesEtudes = anneesEtudes;
	}

	
	public String sePresenter() {
		return super.sePresenter() + " et j'ai "+ anneesEtudes+ " années d'études !";
	}
	
	public void situationProfessionelle() {

		System.out.println("\nJe suis un stagiaire");

	}
}
