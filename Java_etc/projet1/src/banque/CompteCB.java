package banque;

public class CompteCB extends CompteSimple {
	private CB cb;
	private double comission;
	private int cadeau;
	private double solde;

	public CompteCB(String nom, int numero, double solde, CB cb) {
		super(nom, numero, solde);
		this.cb = cb;
	}

	public CompteCB(String nom, int numero) {
		super(nom, numero);
		this.comission = 1;
		this.cadeau = 20;
		this.solde = 0;
	}

	@Override
	public String toString() {
		return "CompteCB [cb=" + cb + ", comission=" + comission + ", cadeau=" + cadeau + ", solde=" + solde + "]";
	}

}
