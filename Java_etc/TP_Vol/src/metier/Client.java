package metier;

public class Client extends Compte {

	private String nom, mail;
	private Adresse adresse;
	
	
	public Client(String login, String passWord, String nom, String mail, Adresse adresse) {
		super(login, passWord);
		this.nom = nom;
		this.mail = mail;
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String toString() {
		return super.toString() +" Client [nom=" + nom + ", mail=" + mail + ", adresse=" + adresse + "]";
	}

	
	
}
