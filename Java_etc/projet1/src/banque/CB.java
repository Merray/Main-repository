package banque;

public enum CB {
	VISA(10), AMEX(15), MC(0);
	
	private double prix;
	
	private CB(int prix) {
		this.prix = prix;
	}
	
	public double getPrix() {
		return prix;
	}
}
