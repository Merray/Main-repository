package banque_correction;

public class Compte {
	private String nom;
	private static int compteur = 1;
	private int numero;
	protected double solde;
	protected double commission = 1;
	private double cadeau = 20;

	public Compte(String nom, double montant) {
		this.nom = nom;
		solde = montant + cadeau;
		numero = compteur;
		compteur++;

	}

	public Compte(String nom) {
		this(nom, 0);
	}

	public String toString() {
		return nom + " " + solde;
	}

	public boolean crediter(double montant) {
		solde += montant;
		return true;
	}

	public boolean debiter(double montant) {
		boolean retour = false;
		try {
			if (solde - montant < 0) {
				// refus
				throw new DebitException();
			}
			solde -= montant;
			retour = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retour;
	}

	public boolean virement(double montant, Compte compte) {
		if (debiter(montant + commission)) {
			return compte.crediter(montant - compte.commission);
		}
		return false;
	}
}
