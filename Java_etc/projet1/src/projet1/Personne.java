package projet1;

public abstract class Personne implements ToStringable{

	String nom, prenom, adresse;

	public Personne(String nom, String prenom, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;

	}
	
	public Personne(Personne p) {
		
		this(p.nom, p.prenom, p.adresse);
		
	}
	
	public Personne() {
		
		
		
	}
	

	public String sePresenter() {

		return "\nBonjour je m'appelle " + this.prenom + " " + this.nom;

	}

	public void demenager(String adresse) {

		this.adresse = adresse;

	}
	
	public abstract  void situationProfessionelle();
	
	public String getString() {
		
		return sePresenter();
	}

}
