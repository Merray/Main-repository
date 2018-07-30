package banque;

public class CompteVIP extends CompteSimple{
	
	
	public CompteVIP(String nom, int numero, double solde) {
		super(nom, numero, solde);
		comission = 0;
		cadeau = 20;
	}
	
	public CompteVIP(String nom, int numero) {
		super(nom, numero);
		comission = 0;
		cadeau = 20;
		solde = 0;
	}

	
	public boolean debiter(int s) throws NegatifException {

		if (s < 0) {
			throw new NegatifException();
		} else {
			solde -= s;
		}
		return true;
	}
	
}
