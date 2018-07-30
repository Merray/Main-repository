package projet1;

public class Formateur extends Personne{

	private int anneeExperience;
	
	public Formateur(String nom, String prenom, String adresse, int anneeExperience) {
		super(nom, prenom, adresse);
		this.anneeExperience = anneeExperience;
	}

	public Formateur() {
		super();
	}
	
	public String sePresenter() {
		return super.sePresenter() + " et j'ai "+ anneeExperience+ " années d'expérience !";
	}
	
	public void situationProfessionelle() {
		
		System.out.println("\nJe suis un formateur");
		
	}
}
