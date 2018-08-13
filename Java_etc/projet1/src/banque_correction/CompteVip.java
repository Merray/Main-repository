package banque_correction;

public class CompteVip extends Compte {

	public CompteVip(String nom) {
		super(nom);
		commission = 0;
	}

	public CompteVip(String nom, double montant) {
		super(nom, montant);
		commission = 0;
	}

	@Override
	public boolean debiter(double montant) {
		solde -= montant;
		return true;
	}
}
