package banque_correction;

public class CompteCB extends Compte {
	private CB cb;

	/**
	 * @param nom
	 * @param montant
	 * @param cb
	 */
	public CompteCB(String nom, double montant, CB cb) {
		super(nom, montant - cb.getPrix());
		this.cb = cb;
	}

	/**
	 * @param nom
	 * @param cb
	 */
	public CompteCB(String nom, CB cb) {
		super(nom, -cb.getPrix());
		this.cb = cb;
	}

	public String toString() {
		return super.toString() + " " + cb;
	}
}
