package projetInterface;

public class Electro extends Article implements Piece, Solde, Descriptable{
	
	int stock;
	
	public Electro(double prixAchat, double prixVente, String nom, String fournisseur) {
		super(prixAchat, prixVente, nom, fournisseur);
		this.stock = 0;
	}

	public void remplirStock(int nombre) {
		stock += nombre;
	}

	@Override
	public String toString() {
		return "Electro [stock=" + stock + ", prixAchat=" + prixAchat + ", prixVente=" + prixVente + ", nom=" + nom
				+ ", fournisseur=" + fournisseur+ ", rendement : "+ this.tauxRendement() + "]";
	}
	
	@Override
	public void desc() {
		System.out.println();
		System.out.println("------------ Mon Electroménager ------------\n\n"
				+ "Nom: "+ nom + "\n" 
				+ "Prix d'achat: "+ prixAchat + "\n" 
				+ "Prix de revente: "+ prixVente + "\n"
				+ "Stock: "+ stock + "\n"
				+ "Fournisseur: "+ fournisseur + "\n"
				+ "Rendement : "+ tauxRendement()+ "\n\n-------------------------------------");
		
	}

	@Override
	public void soldeOn(double pourcentage) {
		
		double discount = prixVente*(pourcentage/100);
		prixVente -= discount;
		
	}

	@Override
	public void soldeOff(double pourcentage) {
		double discount = prixVente*(pourcentage/100);
		prixVente += discount;
		
	}

	@Override
	public double vendrePiece(int quantite) {
		stock -= quantite;
		return quantite*prixVente;
	}


	
	

	
}
