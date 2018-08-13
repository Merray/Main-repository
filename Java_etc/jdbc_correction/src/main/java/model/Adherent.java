package model;

public class Adherent {
	private Integer numeroAdherent;
	private String prenom;
	private String nom;

	public Adherent() {

	}

	/**
	 * @param numeroAdherent
	 * @param prenom
	 * @param nom
	 */
	public Adherent(Integer numeroAdherent, String prenom, String nom) {
		this.numeroAdherent = numeroAdherent;
		this.prenom = prenom;
		this.nom = nom;
	}

	/**
	 * @param prenom
	 * @param nom
	 */
	public Adherent(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Integer getNumeroAdherent() {
		return numeroAdherent;
	}

	public void setNumeroAdherent(Integer numeroAdherent) {
		this.numeroAdherent = numeroAdherent;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
