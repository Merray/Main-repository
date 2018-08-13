package banque_correction;

public enum CB {
	VISA(10), AMEX(15), MC(0);
	private double prix;

	private CB(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}
}
