package banque;

import exceptions.NegatifException;

public class CompteSimple {
	private String nom;
	private int numero;
	protected double solde;
	protected int comission;
	protected int cadeau;

	public CompteSimple(String nom, int numero, double solde) {
		this.nom = nom;
		this.numero = numero;
		this.solde = solde;
		this.comission = 1;
		this.cadeau = 20;
	}

	public CompteSimple(String nom, int numero) {
		this.nom = nom;
		this.numero = numero;
		this.solde = 0;
		this.comission = 1;
		this.cadeau = 20;
	}

	@Override
	public String toString() {
		return "------------ Mon Compte ------------\n\n" + "Nom: " + nom + "\n" + "Numéro: " + numero + "\n"
				+ "Solde: " + solde + "\n" + "Comission: " + comission + "\n" + "Cadeau: " + cadeau
				+ "\n\n-------------------------------------";

	}

	// DECOUVERT INTERDIT
	public boolean debiter(int s) throws DecouvertException, banque.NegatifException {

		boolean etat = false;
		
		if (s > solde || s < 0) {
			throw new DecouvertException();
		} else {
			solde -= s;
			etat = true;
		}
		return etat;
	}

	public boolean crediter(int s) throws banque.NegatifException {

		boolean etat = false;
		
		if (s < 0) {
			throw new banque.NegatifException();
		} else {
			solde += s;
			etat = true;
		}
		return etat;
		
	}

	public boolean virement(int s, CompteSimple c)
			throws DecouvertException, banque.NegatifException {

		double sommePlusCom = s + comission;
		boolean etat = false;
		if (s < 0) {
			throw new banque.NegatifException();
		} else if (sommePlusCom > solde || c.comission > c.solde) {
			throw new DecouvertException();
		} else {
			solde -= sommePlusCom;
			c.solde -= c.comission;
			c.solde += s;
			etat = true;
		}

		return etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getComission() {
		return comission;
	}

	public void setComission(int comission) {
		this.comission = comission;
	}

	public int getCadeau() {
		return cadeau;
	}

	public void setCadeau(int cadeau) {
		this.cadeau = cadeau;
	}

}
